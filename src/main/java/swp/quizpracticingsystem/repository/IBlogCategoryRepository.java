package swp.quizpracticingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import swp.quizpracticingsystem.dto.PostCategoryDTO;
import swp.quizpracticingsystem.model.PostCategory;

public interface IBlogCategoryRepository extends JpaRepository<PostCategory, Integer> {
    PostCategory findByPostCategoryId(int id);

}
