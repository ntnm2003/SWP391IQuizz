package swp.quizpracticingsystem.serviceImple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swp.quizpracticingsystem.dto.PostCategoryDTO;
import swp.quizpracticingsystem.model.PostCategory;
import swp.quizpracticingsystem.model.Posts;
import swp.quizpracticingsystem.repository.IBlogCategoryRepository;
import swp.quizpracticingsystem.service.IBlogCategoryService;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogCategoryService implements IBlogCategoryService {

    @Autowired
    private IBlogCategoryRepository iBlogCategoryRepository;

    @Override
    public PostCategory findByPostCategoryId(int id) {
        PostCategory results = iBlogCategoryRepository.findByPostCategoryId(id);
//        PostCategoryDTO results = new PostCategoryDTO();
//        results.entityToDTO(postCategory);
        return results;
    }

    @Override
    public List<PostCategoryDTO> getAllCategories() {
        List<PostCategoryDTO> results = new ArrayList<>();
        List<PostCategory> posts = iBlogCategoryRepository.findAll();
        for(PostCategory post : posts) {
            PostCategoryDTO categoryDTO = new PostCategoryDTO();
            categoryDTO.entityToDTO(post);
            results.add(categoryDTO);
        }
        return results;
    }
}
