/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package swp391.quizpracticing.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import swp391.quizpracticing.model.Question;

import java.util.List;

/**
 *
 * @author Mosena
 */
public interface IQuestionService {
    public Question getQuestionsById(Integer id);

    public Page<Question> findPaginated(Pageable pageable,List<Question> listQuestion);
}
