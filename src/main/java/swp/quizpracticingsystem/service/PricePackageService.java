package swp.quizpracticingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swp.quizpracticingsystem.model.PricePackage;
import swp.quizpracticingsystem.model.SubjectDetail;
import swp.quizpracticingsystem.model.User;
import swp.quizpracticingsystem.repository.PricePackageRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class PricePackageService {
    @Autowired private PricePackageRepo packageRepo;
    public List<PricePackage> listAll() {
        return packageRepo.findAll();
    }

    public void save(PricePackage pricePackage) {packageRepo.save(pricePackage);
    }
    public PricePackage getById(Integer id){
        return packageRepo.getById(id);
    }
    public List<PricePackage> getBySubject(Integer subId){
        List<PricePackage> pi =new ArrayList<>();
        for (PricePackage p: listAll()){
            if (p.getSubject().getIdCourse()==subId){
                PricePackage p1=p;
                pi.add(p1);
            }
        }
        return pi;
    }
}
