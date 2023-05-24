package swp.quizpracticingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swp.quizpracticingsystem.model.Subject;
import swp.quizpracticingsystem.model.SubjectDetail;
import swp.quizpracticingsystem.model.User;
import swp.quizpracticingsystem.repository.SubjectDetailRepo;
import swp.quizpracticingsystem.repository.SubjectRepository;

import java.util.List;
@Service("subjectService")
public class SubjectService  {
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private SubjectDetailRepo subjectDetailRepo;
    public List<Subject> listAll() {
        return (List<Subject>) subjectRepository.findAll();
    }

    public void save(Subject subject) {
        subjectRepository.save(subject);
    }
    public Subject getById(Integer id){
        return subjectRepository.getById(id);
    }
}
