/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package swp391.quizpracticing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import swp391.quizpracticing.model.UserSubject;
import swp391.quizpracticing.model.UserSubjectKey;

import java.util.List;

/**
 *
 * @author Mosena
 */
@Repository
public interface IUserSubjectRepository extends JpaRepository<UserSubject,UserSubjectKey> {

    @Query(value = "select * from iquiz.user_subject where user_id = :user_id and registration_status_id = :registration_status_id", nativeQuery = true)
    public List<UserSubject> getAllByUserIdAndRegistrationStatus(@Param("user_id") Integer userId, @Param("registration_status_id") Integer registrationId);
}
