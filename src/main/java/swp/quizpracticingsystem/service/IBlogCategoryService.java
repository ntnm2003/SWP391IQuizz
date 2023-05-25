package swp.quizpracticingsystem.service;

import swp.quizpracticingsystem.dto.PostCategoryDTO;
import swp.quizpracticingsystem.model.PostCategory;

import java.util.List;

public interface IBlogCategoryService {

    public PostCategory findByPostCategoryId(int id);

    public List<PostCategoryDTO> getAllCategories();
}
