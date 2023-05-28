package swp.quizpracticingsystem.serviceImple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swp.quizpracticingsystem.model.SubjectDetail;
import swp.quizpracticingsystem.repository.ISubjectDetailRepository;
import swp.quizpracticingsystem.service.ISubjectDetailService;

import java.util.List;

@Service
public class SubjectDetailService implements ISubjectDetailService {
    @Autowired
    private ISubjectDetailRepository subjectDetailRepository;
    @Override
    public List<SubjectDetail> getAllSubjectDetail() {
        return subjectDetailRepository.findAll();
    }

}
