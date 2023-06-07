/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package swp391.quizpracticing.service;

import swp391.quizpracticing.dto.LessonDTO;

/**
 *
 * @author Mosena
 */
public interface ILessonService {

    public LessonDTO findById(int id);
}
