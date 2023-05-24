package swp.quizpracticingsystem.serviceImple;

import org.springframework.stereotype.Service;
import swp.quizpracticingsystem.model.Category;
import swp.quizpracticingsystem.repository.ICategoryRepository;
import swp.quizpracticingsystem.service.ICategoryService;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    ICategoryRepository categoryRepository;

    public CategoryService(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> listAll() {
        return categoryRepository.findAll();
    }

    public Category getById(Integer id) {
        return categoryRepository.getById(id);
    }
}
