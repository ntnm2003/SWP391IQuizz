package swp.quizpracticingsystem.serviceImple;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swp.quizpracticingsystem.dto.PostsDTO;
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

	@Override
	public List<PostsDTO> getFeaturedPosts(boolean isFeatured) {
		List<Posts> featuredPosts = blogRepository.findByFeaturing(isFeatured);
		List<PostsDTO> results = new ArrayList<>();
		for(Posts post : featuredPosts) {
			PostsDTO postsDTO = new PostsDTO();
			postsDTO.postsHomePage(post);
			results.add(postsDTO);
		}
		return results;
	}

	@Override
	public List<PostsDTO> getLatestPosts(boolean isFeatured, int limit) {
		List<Posts> lastestPosts = blogRepository.findByFeaturingOrderByUpdatedDate(isFeatured, limit);
		List<PostsDTO> results = new ArrayList<>();
		for(Posts post : lastestPosts) {
			PostsDTO postsDTO = new PostsDTO();
			postsDTO.postsHomePage(post);
			results.add(postsDTO);
		}
		return results;

	}

}
