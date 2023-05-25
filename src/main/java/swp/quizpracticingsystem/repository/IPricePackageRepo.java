package swp.quizpracticingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import swp.quizpracticingsystem.model.PricePackage;

public interface IPricePackageRepo extends JpaRepository<PricePackage, Integer> {

}
