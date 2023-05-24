package swp.quizpracticingsystem.service;

import swp.quizpracticingsystem.model.SubjectOverview;

import java.util.List;

public interface ISubjectOverviewService {

    List<SubjectOverview> getAllSubjectOverview();

    List<SubjectOverview> getSObyFeaturing(String featuring);
}
