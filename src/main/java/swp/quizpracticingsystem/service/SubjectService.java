package swp.quizpracticingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swp.quizpracticingsystem.model.Subject;
import swp.quizpracticingsystem.repository.SubjectRepository;

@Service("subjectService")
public class SubjectService  {
    @Autowired
    private SubjectRepository subjectDetailRepo;
    public Subject get(int idSub){
        if (subjectDetailRepo.findById(idSub).isPresent()) {
            return subjectDetailRepo.findById(idSub).get();
        } else {
            return null;
        }
    }

}
