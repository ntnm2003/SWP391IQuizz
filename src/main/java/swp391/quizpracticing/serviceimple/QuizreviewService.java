/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp391.quizpracticing.serviceimple;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swp391.quizpracticing.dto.QuizreviewDTO;
import swp391.quizpracticing.model.Quizreview;
import swp391.quizpracticing.service.IQuizreviewService;

/**
 *
 * @author Mosena
 */
@Service
public class QuizreviewService implements IQuizreviewService {
    @Autowired
    private ModelMapper modelMapper;
    
    private QuizreviewDTO convertEntityToDTO(Quizreview entity){
        return modelMapper.map(entity,QuizreviewDTO.class);
    }
}
