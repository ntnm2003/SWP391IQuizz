/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp391.quizpracticing.serviceimple;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swp391.quizpracticing.dto.SliderDTO;
import swp391.quizpracticing.model.Slider;
import swp391.quizpracticing.service.ISliderService;

/**
 *
 * @author Mosena
 */
@Service
public class SliderService implements ISliderService {
    @Autowired
    private ModelMapper modelMapper;
    
    private SliderDTO convertEntityToDTO(Slider entity){
        return modelMapper.map(entity,SliderDTO.class);
    }
}
