package swp.quizpracticingsystem.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import swp.quizpracticingsystem.model.Subject;
import swp.quizpracticingsystem.model.SubjectOverview;

import java.util.List;

public interface ISubjectOverviewRepository extends JpaRepository<SubjectOverview, Integer> {

    List<SubjectOverview> findByFeaturing(String featuring);

    @Override
    public Page<SubjectOverview> findAll(Pageable pageable);

    @Override
    public List<SubjectOverview> findAll();

    SubjectOverview findByIdOverview(int idOverview);
}
