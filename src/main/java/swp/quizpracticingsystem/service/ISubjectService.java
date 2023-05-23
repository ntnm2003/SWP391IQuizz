package swp.quizpracticingsystem.service;

import swp.quizpracticingsystem.model.Subject;
import org.springframework.data.domain.Page;
import swp.quizpracticingsystem.dto.SubjectDTO;

import java.util.List;

public interface ISubjectService {

    List<Subject> findByFeaturing(List<Integer> ids);
    public Page<SubjectDTO> findPaginatedAllSubjects(int pageNo, int pageSize);

}
