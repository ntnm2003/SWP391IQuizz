/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package swp391.quizpracticing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import swp391.quizpracticing.model.Quizreview;
import swp391.quizpracticing.model.User;

import java.util.List;

/**
 *
 * @author Mosena
 */
@Repository
public interface IQuizreviewRepository extends JpaRepository<Quizreview,Integer> {

    @Query(value = "select * from iquiz.quizreview where user_id = :user_id", nativeQuery = true)
    public List<Quizreview> findAllByUserId(@Param("user_id") Integer userId);
}
