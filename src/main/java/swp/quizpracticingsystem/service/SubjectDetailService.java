package swp.quizpracticingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swp.quizpracticingsystem.model.SubjectDetail;
import swp.quizpracticingsystem.model.User;
import swp.quizpracticingsystem.repository.SubjectDetailRepo;

import java.util.List;

@Service
public class SubjectDetailService {
    @Autowired private SubjectDetailRepo subjectDetailRepo;
    @Autowired private PricePackageService pricePackageService;
    public List<SubjectDetail> listAll() {
        return (List<SubjectDetail>) subjectDetailRepo.findAll();
    }

    public void save(SubjectDetail subjectDetail) {
        subjectDetailRepo.save(subjectDetail);
    }
    public SubjectDetail getById(Integer id){
        return subjectDetailRepo.getById(id);
    }
}
