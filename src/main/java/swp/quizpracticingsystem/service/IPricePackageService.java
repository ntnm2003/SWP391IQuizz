package swp.quizpracticingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swp.quizpracticingsystem.model.PricePackage;
import swp.quizpracticingsystem.repository.IPricePackageRepo;

import java.util.ArrayList;
import java.util.List;

public interface IPricePackageService {

    public List<PricePackage> listAll();

    public void save(PricePackage pricePackage);

    public PricePackage getById(Integer id);

    public List<PricePackage> getBySubject(Integer subId);
}
