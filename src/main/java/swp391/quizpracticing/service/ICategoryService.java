/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package swp391.quizpracticing.service;

import swp391.quizpracticing.model.Category;

import java.util.List;

/**
 *
 * @author Mosena
 */
public interface ICategoryService {
    List<Category> listAll();

    Category getById(int id);
}
