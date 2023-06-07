/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp391.quizpracticing.serviceimple;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swp391.quizpracticing.dto.CategoryDTO;
import swp391.quizpracticing.model.Category;
import swp391.quizpracticing.repository.ICategoryRepository;
import swp391.quizpracticing.service.ICategoryService;

import java.util.List;

/**
 *
 * @author Mosena
 */
@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ICategoryRepository categoryRepository;
    private CategoryDTO convertEntityToDTO(Category entity){
        return modelMapper.map(entity,CategoryDTO.class);
    }

    @Override
    public List<Category> listAll() {
        return categoryRepository.findAll();
    }
}
