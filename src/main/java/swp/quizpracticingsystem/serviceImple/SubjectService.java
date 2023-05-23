package swp.quizpracticingsystem.serviceImple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swp.quizpracticingsystem.model.Subject;
import swp.quizpracticingsystem.repository.ISubjectRepository;
import swp.quizpracticingsystem.service.ISubjectService;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectService implements ISubjectService {

    @Autowired
    private ISubjectRepository subjectRepository;

    @Override
    public List<Subject> findByFeaturing(List<Integer> ids) {
        List<Subject> featuringSubjects = new ArrayList<>();
        for(int i=0; i< ids.size(); i++) {
            Subject featuringSubject = subjectRepository.findByIdCourse(ids.get(i));
            featuringSubjects.add(featuringSubject);
        }
        return featuringSubjects;
    }
}
