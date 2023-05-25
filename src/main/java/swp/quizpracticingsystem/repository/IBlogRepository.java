package swp.quizpracticingsystem.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import swp.quizpracticingsystem.model.PostCategory;
import swp.quizpracticingsystem.model.Posts;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Posts, Integer> {
	
	List<Posts> findByFeaturing(boolean isFeatured);

	@Query(value = "select * from iquiz.posts where featuring = ?1 order by updated_date desc limit ?2", nativeQuery = true)
	List<Posts> findByFeaturingOrderByUpdatedDate(boolean isFeatured, int limit);

	@Query(value = "select * from iquiz.posts order by updated_date desc limit ?1", nativeQuery = true)
	List<Posts> findByUpdatedDate(int limit);

	List<Posts> findByTitleContainingIgnoreCase(String searchTerm);

	List<Posts> findByPostCategoryIn(List<PostCategory> categories);



}
