package swp.quizpracticingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import swp.quizpracticingsystem.model.SubjectDetail;
import swp.quizpracticingsystem.model.SubjectOverview;

import java.util.List;

public interface ISubjectDetailRepository extends JpaRepository<SubjectDetail, Integer> {

}
