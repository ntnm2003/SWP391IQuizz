/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp391.quizpracticing.serviceimple;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

import java.util.Arrays;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import swp391.quizpracticing.dto.UserDTO;
import swp391.quizpracticing.model.Role;
import swp391.quizpracticing.model.User;
import swp391.quizpracticing.repository.IRoleRepository;
import swp391.quizpracticing.repository.IUserRepository;
import swp391.quizpracticing.service.IUserService;

/**
 *
 * @author Mosena
 */
@Service
@Transactional
public class UserService implements IUserService {
    
    @Autowired
    private IUserRepository userRepository;
    
    @Autowired
    private IRoleRepository roleRepository;
    @Autowired
    private ModelMapper modelMapper;

    private UserDTO convertEntityToDTO(User entity){
        return modelMapper.map(entity, UserDTO.class);
    }

    @Override
    public Page<UserDTO> getUsers(int pageNo, int pageSize,
            Boolean gender, Boolean status, Integer roleId, String sortBy, String order) {
        Pageable page;
        if(order.equals("asc")){
            page = PageRequest.of(pageNo - 1, pageSize, 
                    Sort.by(sortBy).ascending());
        }
        else{
            page = PageRequest.of(pageNo - 1, pageSize, 
                    Sort.by(sortBy).descending());
        }
        Specification<User> specification = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (gender != null) {
                predicates.add(criteriaBuilder.equal(root
                        .get("gender"), gender));
            }
            if (status != null) {
                predicates.add(criteriaBuilder.equal(root
                        .get("enable"), status));
            }
            if (roleId != null) {
                predicates.add(criteriaBuilder.equal(root
                        .get("role").get("id"), roleId));
            }

            return criteriaBuilder.and(predicates.toArray(Predicate[]::new));
        };
        Page<User> pageList=userRepository.findAll(specification,page);
        List<UserDTO> list = pageList
                .stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
        return new PageImpl<>(list, page,
                pageList.getTotalElements());
    }

    @Override
    public Page<UserDTO> searchUserBy(int pageNo, int pageSize,
            String searchValue, Boolean gender, Boolean status, Integer roleId, 
            String sortBy, String order) {
        Pageable page;
        String searchPattern = "%" + searchValue + "%";
        String searchBy;
        if(searchValue.contains("@")){
            searchBy="email";
        }
        else if(searchValue.matches("\\d+")){
            searchBy="mobile";
        }
        else{
            searchBy="fullName";
        }
        if(order.equals("asc")){
            page = PageRequest.of(pageNo - 1, pageSize, 
                    Sort.by(sortBy).ascending());
        }
        else{
            page = PageRequest.of(pageNo - 1, pageSize, 
                    Sort.by(sortBy).descending());
        }
        Specification<User> specification=(root, query, criteriaBuilder) -> {
            List<Predicate> predicates=new ArrayList<>();
            if(gender!=null){
                predicates.add(criteriaBuilder.equal(root
                        .get("gender"), gender));
            }
            if(status!=null){
                predicates.add(criteriaBuilder.equal(root
                        .get("enable"), status));
            }
            if (roleId != null) {
                predicates.add(criteriaBuilder.equal(root
                        .get("role").get("id"), roleId));
            }
            predicates.add(criteriaBuilder.like(root
                    .get(searchBy), searchPattern));
            return criteriaBuilder.and(predicates.toArray(Predicate[]::new));
        };
        Page<User> pageList=userRepository.findAll(specification,page);
        List<UserDTO> list = pageList
                .stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
        return new PageImpl<>(list, page,
                pageList.getTotalElements());
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public int countUsersByRolesLike(String role) {
        return userRepository.countUsersByRolesLike(role);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("Email does not exist in system. Please re-enter another email!");
        }
        return new org.springframework.security.core.userdetails.User(

                user.getEmail(),
                user.getPassword(),
                Arrays.stream(user.getRole().getName().split(","))
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList())
        );
    }

    @Override
    public UserDTO addUser(String fullName, String email, String password) {
        User u=new User();
        u.setFullName(fullName);
        u.setEmail(email);
        u.setPassword(password);
        return convertEntityToDTO(userRepository.save(u));
    }

    @Override
    public void updateUser(Integer userId, Integer roleId, Boolean status) {
        if(roleId!=null){
            Role r=roleRepository.getReferenceById(roleId);
            userRepository.updateUserRole(userId, r);
        }
        if(status!=null){
            userRepository.updateUserStatus(userId, status);
        }
    }
}
