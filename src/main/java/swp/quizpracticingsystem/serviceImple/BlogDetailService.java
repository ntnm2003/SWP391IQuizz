package swp.quizpracticingsystem.serviceImple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swp.quizpracticingsystem.model.Posts;
import swp.quizpracticingsystem.repository.BlogDetailRepo;
import swp.quizpracticingsystem.service.IBlogDetailService;


@Service
public class BlogDetailService implements IBlogDetailService {
    @Autowired
    private BlogDetailRepo blogRepository;


    @Override
    public Posts getPostById(Integer id) {
        return blogRepository.findById(id).get();
    }
}
