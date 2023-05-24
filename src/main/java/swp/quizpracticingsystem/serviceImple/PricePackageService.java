package swp.quizpracticingsystem.serviceImple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import swp.quizpracticingsystem.model.PricePackage;
import swp.quizpracticingsystem.repository.IPricePackageRepo;
import swp.quizpracticingsystem.service.IPricePackageService;

import java.util.ArrayList;
import java.util.List;
@Service
public class PricePackageService implements IPricePackageService {

    private final IPricePackageRepo packageRepo;
    public PricePackageService(IPricePackageRepo packageRepo){
        super();
        this.packageRepo=packageRepo;
    }
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
