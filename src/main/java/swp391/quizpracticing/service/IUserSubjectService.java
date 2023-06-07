/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package swp391.quizpracticing.service;

import swp391.quizpracticing.dto.SubjectDTO;
import swp391.quizpracticing.dto.UserSubjectDTO;
import swp391.quizpracticing.model.Subject;
import swp391.quizpracticing.model.UserSubject;

import java.util.List;

/**
 *
 * @author Mosena
 */
public interface IUserSubjectService {
    public List<UserSubject> listAll();
    public void save(UserSubject usercourse) ;
    public UserSubject getId(UserSubject uk);
    public List<Subject> courseById(Integer id);
    
}
