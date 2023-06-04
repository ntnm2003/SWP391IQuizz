/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp391.quizpracticing.serviceimple;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swp391.quizpracticing.dto.PricepackageDTO;
import swp391.quizpracticing.model.Pricepackage;
import swp391.quizpracticing.service.IPricepackageService;

/**
 *
 * @author Mosena
 */
@Service
public class PricepackageService implements IPricepackageService {
    @Autowired
    private ModelMapper modelMapper;
    
    private PricepackageDTO convertEntityToDTO(Pricepackage entity){
        return modelMapper.map(entity,PricepackageDTO.class);
    }
}
