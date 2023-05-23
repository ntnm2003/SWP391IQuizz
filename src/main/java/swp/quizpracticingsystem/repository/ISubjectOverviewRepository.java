package swp.quizpracticingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import swp.quizpracticingsystem.model.SubjectOverview;

import java.util.List;

public interface ISubjectOverviewRepository extends JpaRepository<SubjectOverview, Integer> {

    List<SubjectOverview> findByFeaturing(String featuring);
}
