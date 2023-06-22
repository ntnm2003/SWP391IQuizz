/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp391.quizpracticing.serviceimple;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swp391.quizpracticing.dto.BlogcategoryDTO;
import swp391.quizpracticing.model.Blogcategory;
import swp391.quizpracticing.service.IBlogcategoryService;

/**
 *
 * @author Mosena
 */
@Service
public class BlogcategoryService implements IBlogcategoryService {
    @Autowired
    private ModelMapper modelMapper;
    
    private BlogcategoryDTO convertEntityToDTO(Blogcategory entity){
        return modelMapper.map(entity,BlogcategoryDTO.class);
    }
}
