/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package swp.quizpracticingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import swp.quizpracticingsystem.model.SubjectOverview;

/**
 *
 * @author Mosena
 */
@Repository
public interface ISubjectOverviewRepository extends 
                        JpaRepository<SubjectOverview, Integer> {
    @Query(value="select * from subject_overview "
            + "where idsub=?1",nativeQuery = true)
    public SubjectOverview findSubjectOverview(int subjectId);
}
