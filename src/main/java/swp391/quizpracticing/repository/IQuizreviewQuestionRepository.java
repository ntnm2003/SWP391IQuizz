/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package swp391.quizpracticing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import swp391.quizpracticing.model.QuizreviewQuestion;
import swp391.quizpracticing.model.QuizreviewQuestionKey;

import java.util.List;

/**
 *
 * @author Mosena
 */
@Repository
public interface IQuizreviewQuestionRepository extends JpaRepository<QuizreviewQuestion,QuizreviewQuestionKey> {

    @Query(value = "select * from iquiz.quizreview_question where quizreview_id = :quizreview_id", nativeQuery = true)
    public List<QuizreviewQuestion> getAllByQuizreviewId(@Param("quizreview_id") Integer quizreviewId);

    @Query(value = "select count(is_correct) from iquiz.quizreview_question where quizreview_id = :quizreview_id and is_correct = :is_correct", nativeQuery = true)
    public Integer getNumberOfCorrectAnswer(@Param("quizreview_id") Integer quizreviewId, @Param("is_correct") Boolean isCorrect);


}
