/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package swp.quizpracticingsystem.service;

import java.util.List;
import swp.quizpracticingsystem.dto.CategoryDTO;
import swp.quizpracticingsystem.model.Category;

/**
 *
 * @author Mosena
 */
public interface ICategoryService {
    public List<CategoryDTO> findAll();
    public List<Category> listAll() ;
    public Category getById(Integer id) ;
}
