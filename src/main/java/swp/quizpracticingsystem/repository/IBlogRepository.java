package swp.quizpracticingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import swp.quizpracticingsystem.model.Posts;

import java.util.List;
@Repository
public interface IBlogRepository extends JpaRepository<Posts, Integer> {
	
	List<Posts> findByFeaturing(boolean isFeatured);

	@Query(value = "select * from iquiz.posts where featuring = ?1 order by updated_date desc limit ?2", nativeQuery = true)
	List<Posts> findByFeaturingOrderByUpdatedDate(boolean isFeatured, int limit);

}
