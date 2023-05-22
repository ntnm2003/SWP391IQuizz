package swp.quizpracticingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import swp.quizpracticingsystem.model.Subject;

public interface ISubjectRepository extends JpaRepository<Subject, Integer> {

    
}
