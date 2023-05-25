
package swp.quizpracticingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import swp.quizpracticingsystem.model.Category;

import java.util.List;


@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findCategoriesByCatNameContains(String catName);


    @Override
    public List<Category> findAll();
}

