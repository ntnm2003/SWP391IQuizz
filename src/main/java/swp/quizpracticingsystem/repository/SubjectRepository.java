package swp.quizpracticingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import swp.quizpracticingsystem.model.Subject;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    @Override
    List<Subject> findAll();

    @Override
    Subject getById(Integer integer);

    @Override
    List<Subject> findAllById(Iterable<Integer> integers);
}
