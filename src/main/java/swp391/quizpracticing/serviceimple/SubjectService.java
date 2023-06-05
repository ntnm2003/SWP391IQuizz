/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp391.quizpracticing.serviceimple;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swp391.quizpracticing.dto.SubjectDTO;
import swp391.quizpracticing.model.Subject;
import swp391.quizpracticing.service.ISubjectService;

/**
 *
 * @author Mosena
 */
@Service
public class SubjectService implements ISubjectService {
    @Autowired
    private ModelMapper modelMapper;
    
    private SubjectDTO convertEntityToDTO(Subject entity){
        return modelMapper.map(entity,SubjectDTO.class);
    }
}
