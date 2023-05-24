package swp.quizpracticingsystem.serviceImple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swp.quizpracticingsystem.dto.SubjectOverviewDTO;
import swp.quizpracticingsystem.model.Subject;
import swp.quizpracticingsystem.model.SubjectOverview;
import swp.quizpracticingsystem.repository.SubjectRepository;
import swp.quizpracticingsystem.service.ISubjectDetailService;

@Service
public class SubjectDetailService implements ISubjectDetailService {
    @Autowired
    private SubjectRepository subjectRepository;

    public SubjectOverview convertFromSubjectOverviewDTO(SubjectOverviewDTO dto) {
        SubjectOverview subject = new SubjectOverview();
        if (!dto.getIdOverview().equals("")) {
            subject.setIdOverview(dto.getIdOverview());
        }
        subject.setStatus(dto.getStatus());
        subject.setDescription(dto.getDescription());
        subject.setTagLine(dto.getTagLine());


        return subject;
    }

    @Override
    public Subject getSubjectById(Integer idOverview) {
        return subjectRepository.findById(idOverview).get();
    }
}
