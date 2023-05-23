package swp.quizpracticingsystem.service;

import org.springframework.stereotype.Service;
import swp.quizpracticingsystem.model.Category;
import swp.quizpracticingsystem.repository.CategoryRepository;

import java.util.List;
@Service
public class CategoryService  {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> listAll() {
        return categoryRepository.findAll();
    }

    public Category getById(Integer id) {
        return categoryRepository.getById(id);
    }
}
