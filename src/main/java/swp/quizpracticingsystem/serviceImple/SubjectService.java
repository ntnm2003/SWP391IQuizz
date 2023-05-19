/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp.quizpracticingsystem.serviceImple;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import swp.quizpracticingsystem.dto.CourseDTO;
import swp.quizpracticingsystem.model.Course;
import swp.quizpracticingsystem.repository.ISubjectRepository;
import swp.quizpracticingsystem.service.ISubjectService;

/**
 *
 * @author Mosena
 */
@Service
@Transactional
public class SubjectService implements ISubjectService {

    @Autowired
    private ISubjectRepository iSubjectRepository;
    
    @Autowired
    private ModelMapper modelmapper;
    
    @Override
    public Page<CourseDTO> findPaginatedAllSubjects(int pageNo, int pageSize) {
        Pageable pageable=PageRequest.of(pageNo-1,pageSize);
        List<CourseDTO> paginatedList=iSubjectRepository.findAll(pageable)
                .stream()
                .map(this::convertEntitytoDTO)
                .collect(Collectors.toList());
        return new PageImpl<>(paginatedList);
    }
    
    public CourseDTO convertEntitytoDTO(Course entity){
        return modelmapper.map(entity, CourseDTO.class);
    }
    
}
