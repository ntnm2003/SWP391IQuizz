package swp.quizpracticingsystem.service;

import java.util.List;

import swp.quizpracticingsystem.dto.PostsDTO;
import swp.quizpracticingsystem.model.Posts;

public interface IBlogService {

	List<Posts> getAllBlogs();

	List<PostsDTO> getFeaturedPosts(boolean isFeatured);

	List<PostsDTO> getLatestPosts(boolean isFeatured, int limit);
	
}
