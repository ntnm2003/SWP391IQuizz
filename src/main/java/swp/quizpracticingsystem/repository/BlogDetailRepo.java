package swp.quizpracticingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import swp.quizpracticingsystem.model.Posts;
import java.util.List;

public interface BlogDetailRepo extends JpaRepository<Posts, Integer>{

    @Override
    List<Posts> findAll();

    @Override
    Posts getById(Integer integer);

    @Override
    List<Posts> findAllById(Iterable<Integer> integers);
}
