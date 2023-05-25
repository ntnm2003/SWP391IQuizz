package swp.quizpracticingsystem.serviceImple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swp.quizpracticingsystem.model.Posts;
import swp.quizpracticingsystem.model.Subject;
import swp.quizpracticingsystem.model.SubjectOverview;
import swp.quizpracticingsystem.repository.BlogDetailRepo;
import swp.quizpracticingsystem.repository.ISubjectOverviewRepository;
import swp.quizpracticingsystem.repository.ISubjectRepository;
import swp.quizpracticingsystem.service.ISubjectOverviewService;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectOverviewService implements ISubjectOverviewService {
    @Autowired
    private ISubjectOverviewRepository subjectOverviewRepository;
    @Autowired
    private ISubjectRepository iSubjectRepository;
//
//    @Autowired
//    private ModelMapper modelmapper;

    @Override
    public SubjectOverview getSubjectById(Integer id) {
        return subjectOverviewRepository.findById(id).get();
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


    @Override
    public List<SubjectOverview> getAllSubjectOverview() {
        return subjectOverviewRepository.findAll();
    }

    @Override
    public List<SubjectOverview> getSObyFeaturing(String featuring) {
        return subjectOverviewRepository.findByFeaturing(featuring);
    }


}



