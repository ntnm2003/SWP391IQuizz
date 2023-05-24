package swp.quizpracticingsystem.service;

import swp.quizpracticingsystem.model.SubjectOverview;

import java.util.List;
import swp.quizpracticingsystem.dto.SubjectOverviewDTO;
import swp.quizpracticingsystem.model.Subject;

public interface ISubjectOverviewService {
    List<SubjectOverview> getAllSubjectOverview();

    List<SubjectOverview> getSObyFeaturing(String featuring);

    SubjectOverviewDTO findSubjectOverview(int subjectId);
    List<Subject> findByFeaturing(List<Integer> ids);
}
