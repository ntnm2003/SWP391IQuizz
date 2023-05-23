package swp.quizpracticingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import swp.quizpracticingsystem.model.Subject;

import java.util.List;

public interface ISubjectRepository extends JpaRepository<Subject, Integer> {

    Subject findByIdCourse(int id);

}
