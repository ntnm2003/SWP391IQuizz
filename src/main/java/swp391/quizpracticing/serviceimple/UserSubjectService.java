/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp391.quizpracticing.serviceimple;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swp391.quizpracticing.dto.UserSubjectDTO;
import swp391.quizpracticing.model.UserSubject;
import swp391.quizpracticing.repository.IUserSubjectRepository;
import swp391.quizpracticing.service.IUserSubjectService;

import java.util.List;

/**
 *
 * @author Mosena
 */
@Service
public class UserSubjectService implements IUserSubjectService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IUserSubjectRepository iUserSubjectRepository;

    @Override
    public List<UserSubject> getAllByUserId(Integer id) {
        return iUserSubjectRepository.getAllByUserIdAndRegistrationStatus(id, 1);
    }
}
