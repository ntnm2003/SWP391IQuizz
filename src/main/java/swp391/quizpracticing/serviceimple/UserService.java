/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp391.quizpracticing.serviceimple;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
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
    public List<UserDTO> getUsers(int pageNo, int pageSize, 
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
        Specification<User> specification=null;
        if(gender!=null && status!=null && roleId!=null){
            specification=(Root<User> root, 
                CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) 
                -> criteriaBuilder
                .and(criteriaBuilder
                        .equal(root.get("gender"),gender),
                    criteriaBuilder
                            .equal(root.get("enable"),status),
                    criteriaBuilder.equal(root.get("role.id"),
                            roleId));
        }
        else if(gender==null && status !=null && roleId==null){
            specification=(Root<User> root,CriteriaQuery<?> query, 
                    CriteriaBuilder criteriaBuilder)-> criteriaBuilder
                            .equal(root.get("enable"), status);
        }
        else if(gender!=null && status ==null && roleId==null){
            specification=(Root<User> root,CriteriaQuery<?> query, 
                    CriteriaBuilder criteriaBuilder)-> criteriaBuilder
                            .equal(root.get("gender"), gender);
        }
        else if(gender==null && status ==null && roleId!=null){
            specification=(Root<User> root,CriteriaQuery<?> query, 
                    CriteriaBuilder criteriaBuilder)-> criteriaBuilder
                            .equal(root.get("role.id"), roleId);
        }
        return userRepository.findAll(specification,page)
                .stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> searchUserBy(int pageNo, int pageSize, String searchBy,
            String searchValue, Boolean gender, Boolean status, Integer roleId, 
            String sortBy, String order) {
        Pageable page;
        String searchPattern = "%" + searchValue + "%";
        if(order.equals("asc")){
            page = PageRequest.of(pageNo - 1, pageSize, 
                    Sort.by(sortBy).ascending());
        }
        else{
            page = PageRequest.of(pageNo - 1, pageSize, 
                    Sort.by(sortBy).descending());
        }
        Specification<User> specification=null;
        if(gender!=null && status!=null){
            specification=(Root<User> root, 
                CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) 
                -> criteriaBuilder
                    .and(criteriaBuilder
                        .like(root.get(searchBy), searchPattern),
                        criteriaBuilder
                        .equal(root.get("gender"),gender),
                    criteriaBuilder
                            .equal(root.get("enable"),status),
                    criteriaBuilder.equal(root.get("role.id"),
                            roleId));
        }
        else if(gender==null && status !=null && roleId==null){
            specification=(Root<User> root,CriteriaQuery<?> query, 
                    CriteriaBuilder criteriaBuilder)-> criteriaBuilder
                        .and(criteriaBuilder
                        .like(root.get(searchBy), searchPattern),
                                criteriaBuilder
                        .equal(root.get("enable"), status));
        }
        else if(gender!=null && status ==null && roleId==null){
            specification=(Root<User> root,CriteriaQuery<?> query, 
                    CriteriaBuilder criteriaBuilder)-> criteriaBuilder
                        .and(criteriaBuilder
                        .like(root.get(searchBy), searchPattern),
                                criteriaBuilder
                        .equal(root.get("gender"), gender));
        }
        else if(gender==null && status ==null && roleId!=null){
            specification=(Root<User> root,CriteriaQuery<?> query, 
                    CriteriaBuilder criteriaBuilder)-> criteriaBuilder
                        .and(criteriaBuilder
                        .like(root.get(searchBy), searchPattern),
                                criteriaBuilder
                        .equal(root.get("role.id"), roleId));
        }
        else if(gender==null && status==null && roleId==null){
            specification=(Root<User> root,CriteriaQuery<?> query, 
                    CriteriaBuilder criteriaBuilder)-> criteriaBuilder
                        .like(root.get(searchBy), searchPattern);
        }
        return userRepository.findAll(specification,page)
                .stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
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
