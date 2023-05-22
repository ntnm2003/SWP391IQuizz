/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp.quizpracticingsystem.serviceImple;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swp.quizpracticingsystem.dto.SubjectOverviewDTO;
import swp.quizpracticingsystem.model.SubjectOverview;
import swp.quizpracticingsystem.repository.ISubjectOverviewRepository;
import swp.quizpracticingsystem.service.ISubjectOverviewService;

/**
 *
 * @author Mosena
 */
@Service
@Transactional
public class SubjectOverviewService implements ISubjectOverviewService {
    @Autowired
    private ISubjectOverviewRepository subjectOverviewRepository;
    
    @Autowired
    private ModelMapper modelmapper;
    
    @Override
    public SubjectOverviewDTO findSubjectOverview(int subjectId) {
        return convertEntitytoDTO(subjectOverviewRepository.
                findSubjectOverview(subjectId));
    }
    
    
    public SubjectOverviewDTO convertEntitytoDTO(SubjectOverview entity){
        return modelmapper.map(entity, SubjectOverviewDTO.class);
    }
}
