/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package swp391.quizpracticing.service;

import swp391.quizpracticing.model.Pricepackage;

import java.util.List;
import swp391.quizpracticing.dto.PricepackageDTO;

/**
 *
 * @author Mosena
 */
public interface IPricepackageService {
    PricepackageDTO getById(Integer id);
    List<PricepackageDTO> getBySubjectId(Integer id);
}
