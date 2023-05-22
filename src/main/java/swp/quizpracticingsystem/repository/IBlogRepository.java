package swp.quizpracticingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import swp.quizpracticingsystem.model.Posts;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Posts, Integer> {
	
	List<Posts> findByFeaturing(boolean isFeatured);

}
