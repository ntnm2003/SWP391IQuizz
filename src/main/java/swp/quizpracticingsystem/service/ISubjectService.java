package swp.quizpracticingsystem.service;

import swp.quizpracticingsystem.model.Subject;

import java.util.List;

public interface ISubjectService {

    List<Subject> findByFeaturing(List<Integer> ids);
}
