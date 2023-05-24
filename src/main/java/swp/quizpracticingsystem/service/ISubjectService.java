package swp.quizpracticingsystem.service;


import org.springframework.data.domain.Page;
import swp.quizpracticingsystem.dto.SubjectDTO;
import swp.quizpracticingsystem.model.Subject;

import java.util.List;

public interface ISubjectService {
    public Page<SubjectDTO> findPaginatedAllSubjects(int pageNo, int pageSize);
    public Page<SubjectDTO> filterSubjectByCategory(int pageNo,
                        int pageSize, int category);
    public Page<SubjectDTO> findSubjectBySubjectName(int pageNo,
                        int pageSize, String subjectName);
    public Page<SubjectDTO> findSubjectNameAndFilter(int pageNo, int pageSize,
                        String subjectName, int categoryId);
    public Page<SubjectDTO> sortSubjectBy(int pageNo, int pageSize,
                        String sortBy,String order);
    public Page<SubjectDTO> filterAndSortSubject(int pageNo, int pageSize,
            int category, String sortBy,String order);
    public Page<SubjectDTO> searchAndSortSubject(int pageNo, int pageSize,
            String subjectName, String sortBy,String order);
    public Page<SubjectDTO> filterAndSearchAndSortSubject(int pageNo,
            int pageSize, int category, String subjectName,
            String sortBy,String order);

    List<Subject> findByFeaturing(List<Integer> ids);

    public Page<SubjectDTO> findPaginatedAllSubjects(int pageNo, int pageSize);


}
