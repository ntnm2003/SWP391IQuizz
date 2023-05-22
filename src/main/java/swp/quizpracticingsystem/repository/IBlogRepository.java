package swp.quizpracticingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import swp.quizpracticingsystem.model.Posts;

public interface IBlogRepository extends JpaRepository<Posts, Integer> {
	
	

}
