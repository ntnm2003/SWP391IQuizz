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
import swp391.quizpracticing.repository.ISliderRepository;
import swp391.quizpracticing.service.ISliderService;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mosena
 */
@Service
public class SliderService implements ISliderService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ISliderRepository sliderRepository;


    private SliderDTO convertEntityToDTO(Slider entity){
        return modelMapper.map(entity,SliderDTO.class);
    }

    @Override
    public List<SliderDTO> getAllSlidersForHomepage() {
        List<Slider> sliders = sliderRepository.findAll();
        List<SliderDTO> results = new ArrayList<>();
        for (Slider slider : sliders) {
            SliderDTO sliderDTO = new SliderDTO();
            sliderDTO = convertEntityToDTO(slider);
            results.add(sliderDTO);
        }
        return results;

    }
}
