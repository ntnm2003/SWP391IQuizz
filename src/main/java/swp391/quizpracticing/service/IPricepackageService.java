/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package swp391.quizpracticing.service;

import swp391.quizpracticing.model.Pricepackage;

import java.util.List;

/**
 *
 * @author Mosena
 */
public interface IPricepackageService {
    Pricepackage getById(Integer id);
    List<Pricepackage> getBySubjectId(Integer id);
}
