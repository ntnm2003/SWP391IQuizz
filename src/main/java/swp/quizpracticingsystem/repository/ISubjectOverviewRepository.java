package swp.quizpracticingsystem.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import swp.quizpracticingsystem.model.Subject;
import swp.quizpracticingsystem.model.SubjectOverview;

import java.util.List;

public interface ISubjectOverviewRepository extends JpaRepository<SubjectOverview, Integer> {

    @Override
    List<SubjectOverview> findAll();

    @Override
    SubjectOverview getById(Integer integer);

    @Override
    List<SubjectOverview> findAllById(Iterable<Integer> integers);

    public List<SubjectOverview> findByFeaturing(String featuring);
}



