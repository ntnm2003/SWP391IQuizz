/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp391.quizpracticing.serviceimple;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swp391.quizpracticing.dto.LessonDTO;
import swp391.quizpracticing.model.Lesson;
import swp391.quizpracticing.service.ILessonService;

/**
 *
 * @author Mosena
 */
@Service
public class LessonService implements ILessonService {
    @Autowired
    private ModelMapper modelMapper;
    
    private LessonDTO convertEntityToDTO(Lesson entity){
        return modelMapper.map(entity,LessonDTO.class);
    }
}
