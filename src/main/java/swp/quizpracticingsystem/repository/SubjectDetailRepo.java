package swp.quizpracticingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import swp.quizpracticingsystem.model.SubjectDetail;
@Repository
public interface SubjectDetailRepo extends JpaRepository<SubjectDetail,Integer> {
}
