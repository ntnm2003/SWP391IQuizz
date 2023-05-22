package swp.quizpracticingsystem.serviceImple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swp.quizpracticingsystem.model.Posts;
import swp.quizpracticingsystem.repository.IBlogRepository;
import swp.quizpracticingsystem.service.IBlogService;

@Service
public class BlogService implements IBlogService {
	
	@Autowired
	private IBlogRepository blogRepository;

	@Override
	public List<Posts> getAllBlogs() {
		return blogRepository.findAll();
	}
	

	
	
}
