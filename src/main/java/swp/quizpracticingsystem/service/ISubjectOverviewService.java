/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package swp.quizpracticingsystem.service;

import org.springframework.stereotype.Repository;
import swp.quizpracticingsystem.dto.SubjectOverviewDTO;

/**
 *
 * @author Mosena
 */
@Repository
public interface ISubjectOverviewService {
    public SubjectOverviewDTO findSubjectOverview(int subjectId);
}
