/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp.quizpracticingsystem.serviceImple;

import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import swp.quizpracticingsystem.dto.SubjectDTO;
import swp.quizpracticingsystem.model.Subject;
import swp.quizpracticingsystem.repository.ISubjectRepository;
import swp.quizpracticingsystem.service.ISubjectService;

/**
 *
 * @author Mosena
 */
@Service(("subjectServiceImpl"))
@Transactional
public class SubjectService implements ISubjectService {

    @Autowired
    private ISubjectRepository iSubjectRepository;

    @Autowired
    private ModelMapper modelmapper;

    @Override
    public Page<SubjectDTO> findPaginatedAllSubjects(int pageNo, int pageSize) {
        Pageable pageable=PageRequest.of(pageNo-1,pageSize);
        List<SubjectDTO> paginatedList=iSubjectRepository.findAll(pageable)
                .stream()
                .map(this::convertEntitytoDTO)
                .collect(Collectors.toList());
        return new PageImpl<>(paginatedList);
    }

    public SubjectDTO convertEntitytoDTO(Subject entity){
        return modelmapper.map(entity, SubjectDTO.class);
    }

    @Override
    public List<Subject> findByFeaturing(List<Integer> ids) {
        List<Subject> featuringSubjects = new ArrayList<>();
        for (Integer id : ids) {
            Subject featuringSubject = iSubjectRepository.findByIdCourse(id);
            featuringSubjects.add(featuringSubject);
        }
        return featuringSubjects;
    }

}
