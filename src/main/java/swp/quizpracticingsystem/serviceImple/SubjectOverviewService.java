package swp.quizpracticingsystem.serviceImple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swp.quizpracticingsystem.model.SubjectOverview;
import swp.quizpracticingsystem.repository.ISubjectOverviewRepository;
import swp.quizpracticingsystem.service.ISubjectOverviewService;

import java.util.List;

@Service
public class SubjectOverviewService implements ISubjectOverviewService {
    @Autowired
    private ISubjectOverviewRepository subjectOverviewRepository;

    @Override
    public List<SubjectOverview> getAllSubjectOverview() {
        return subjectOverviewRepository.findAll();
    }

    @Override
    public List<SubjectOverview> getSObyFeaturing(String featuring) {
        return subjectOverviewRepository.findByFeaturing(featuring);
    }
}
