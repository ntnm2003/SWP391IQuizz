/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package swp.quizpracticingsystem.service;

import org.springframework.data.domain.Page;
import swp.quizpracticingsystem.dto.SubjectDTO;

/**
 *
 * @author Mosena
 */
public interface ISubjectService {
    public Page<SubjectDTO> findPaginatedAllSubjects(int pageNo, int pageSize);
    
}
