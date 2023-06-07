/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp391.quizpracticing.serviceimple;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swp391.quizpracticing.dto.SubcategoryDTO;
import swp391.quizpracticing.model.Subcategory;
import swp391.quizpracticing.service.ISubcategoryService;

/**
 *
 * @author Mosena
 */
@Service
public class SubcategoryService implements ISubcategoryService {
    @Autowired
    private ModelMapper modelMapper;
    
    private SubcategoryDTO convertEntityToDTO(Subcategory entity){
        return modelMapper.map(entity,SubcategoryDTO.class);
    }
}