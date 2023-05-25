package swp.quizpracticingsystem.service;

import swp.quizpracticingsystem.model.Subject;
import swp.quizpracticingsystem.model.SubjectDetail;
import swp.quizpracticingsystem.model.SubjectOverview;

import java.util.List;

public interface ISubjectOverviewService {


    SubjectOverview getSubjectById(Integer id);


    List<SubjectOverview> getAllSubjectOverview();

    List<SubjectOverview> getSObyFeaturing(String featuring);
    
    List<Subject> findByFeaturing(List<Integer> ids);

}
