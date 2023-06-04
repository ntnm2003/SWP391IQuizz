/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp391.quizpracticing.serviceimple;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swp391.quizpracticing.dto.QuestionDTO;
import swp391.quizpracticing.model.Question;
import swp391.quizpracticing.service.IQuestionService;

/**
 *
 * @author Mosena
 */
@Service
public class QuestionService implements IQuestionService {
    @Autowired
    private ModelMapper modelMapper;
    
    private QuestionDTO convertEntityToDTO(Question entity){
        return modelMapper.map(entity,QuestionDTO.class);
    }
}
