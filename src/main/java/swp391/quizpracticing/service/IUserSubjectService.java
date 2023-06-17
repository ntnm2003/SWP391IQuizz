/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package swp391.quizpracticing.service;

import java.sql.Timestamp;
import swp391.quizpracticing.dto.UserSubjectDTO;
import swp391.quizpracticing.model.Subject;

import swp391.quizpracticing.model.UserSubject;

import java.util.List;
import swp391.quizpracticing.dto.PricepackageDTO;
import swp391.quizpracticing.dto.RegistrationstatusDTO;
import swp391.quizpracticing.dto.SubjectDTO;

/**
 *
 * @author Mosena
 */
public interface IUserSubjectService {
    public List<UserSubject> listAll();
    public void save(UserSubject usercourse) ;
    public UserSubject getId(UserSubject uk);
    public List<Subject> courseById(Integer id);
    public List<UserSubject> getAllByUserId(Integer id);

    //Nam's code using DTO instead of entity
    public List<UserSubjectDTO> listAll(int pageNo, int pageSize, String sortBy, 
            String order, String searchCriteria, Timestamp validFrom, 
            Timestamp validTo, RegistrationstatusDTO status);
    public UserSubjectDTO saveRegistration(UserSubjectDTO registration);
    public UserSubjectDTO addRegistration(UserSubjectDTO registration);
}
