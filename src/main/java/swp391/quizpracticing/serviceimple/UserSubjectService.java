/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp391.quizpracticing.serviceimple;

import jakarta.persistence.criteria.Predicate;
import java.sql.Timestamp;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swp391.quizpracticing.model.Subject;
import swp391.quizpracticing.model.UserSubject;
import swp391.quizpracticing.repository.ISubjectRepository;
import swp391.quizpracticing.repository.IUserSubjectRepository;
import swp391.quizpracticing.service.IUserSubjectService;

import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import swp391.quizpracticing.dto.RegistrationstatusDTO;
import swp391.quizpracticing.dto.SubjectDTO;
import swp391.quizpracticing.dto.UserDTO;
import swp391.quizpracticing.dto.UserSubjectDTO;
import swp391.quizpracticing.repository.IUserRepository;

/**
 *
 * @author Mosena
 */
@Service
public class UserSubjectService implements IUserSubjectService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IUserSubjectRepository userSubjectRepository;
    
    @Autowired
    private ISubjectRepository subjectRepository;
    
    @Autowired
    private IUserRepository userRepository;
    
    @Override
    public List<UserSubject> getAllByUserId(Integer id) {
        return userSubjectRepository.getAllByUserIdAndRegistrationStatus(id, 1);
    }

    @Override
    public List<UserSubject> listAll() {

        return (List<UserSubject>) userSubjectRepository.findAll();
    }
    @Override
    public void save(UserSubject userSubject) {

        userSubjectRepository.save(userSubject);
    }

    @Override
    public UserSubject getId(UserSubject uk) {
        return null;
    }

    @Override
    public List<Subject> courseById(Integer id) {
        List<UserSubject> userCourses = listAll();
        List<UserSubject> filteredUserCourses = new ArrayList<>(); // create a new list

        for (UserSubject uc : userCourses) {
            if (uc.getUser().getId().equals(id)) {
                filteredUserCourses.add(uc); // add to the new list instead of original list
            }
        }

        List<Subject> subjects = new ArrayList<>();
        System.out.println(filteredUserCourses.size());
        for (UserSubject userCourse : filteredUserCourses) { // iterate over the filtered list
            Subject sub = subjectRepository.getById(userCourse.getSubject().getId());
            subjects.add(sub);
        }

        return subjects;
    }

    //Nam's code using DTO instead of entity
    @Override
    public List<UserSubjectDTO> listAll(int pageNo, int pageSize, String sortBy, 
            String order, String searchCriteria, 
            Timestamp validFrom, Timestamp validTo,RegistrationstatusDTO status) {
        Pageable page;
        if(order.equals("asc")){
            page=PageRequest.of(pageNo - 1, pageSize,
                    Sort.by(sortBy).ascending());
        }
        else{
            page=PageRequest.of(pageNo - 1, pageSize,
                    Sort.by(sortBy).descending());
        }
        Specification<UserSubject> specification=(root,query,criteriaBuilder)
                ->{
            List<Predicate> predicates=new ArrayList<>();
            if(searchCriteria!=null){
                String searchPattern="%"+searchCriteria+"%";
                if(searchCriteria.contains("@")){
                    predicates.add(criteriaBuilder.like(
                        root.get("user").get("email"), 
                        searchPattern));
                }
                else{
                    predicates.add(criteriaBuilder.like(
                        root.get("subject").get("title"), 
                        searchPattern));
                }
            }
            if(validFrom!=null){
                predicates.add(criteriaBuilder.equal(
                        root.get("validFrom"), 
                        root));
            }
            if(validTo!=null){
                predicates.add(criteriaBuilder.equal(
                        root.get("validTo"), 
                        root));
            }
            if(status!=null){
                predicates.add(criteriaBuilder.equal(
                        root.get("registrationStatus")
                                        .get("name"), 
                        root));
            }
            return criteriaBuilder.and(predicates
                    .stream()
                    .toArray(Predicate[]::new));
        };
        return userSubjectRepository
                .findAll(specification,page)
                .stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }
    
//    @Override
//    public UserSubjectDTO saveRegistration(UserDTO userUpdate, Integer registrationId,
//            UserDTO user, Timestamp registrationTime, Timestamp validFrom, 
//            SubjectDTO subject, Integer pricePackageId, String notes, 
//            RegistrationstatusDTO registrationStatusId) {
//        
//        return null;
//    }

    @Override
    public UserSubjectDTO addRegistration(Integer userUpdate, String email, Timestamp registrationTime, Timestamp validFrom, Integer subjectId, Integer pricePackageId, String notes, Integer registrationStatusId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private UserSubjectDTO convertEntityToDTO(UserSubject entity){
        return modelMapper.map(entity, UserSubjectDTO.class);
    }
}
