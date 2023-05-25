package swp.quizpracticingsystem.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import swp.quizpracticingsystem.dto.PostsDTO;
import swp.quizpracticingsystem.model.PostCategory;
import swp.quizpracticingsystem.model.Posts;

@Service
public interface IBlogService {

	List<PostsDTO> getAllBlogs();

	List<PostsDTO> getFeaturedPosts(boolean isFeatured);

	List<PostsDTO> getFeaturedLatestPosts(boolean isFeatured, int limit);

	List<PostsDTO> getLatestPosts(int limit);

	Page<Posts> getAllPostsWithPagination(int pageNo);

	List<PostsDTO> searchByTitle(String searchTerm);

	List<PostsDTO> getFilteredPosts(List<PostCategory> categories);
	
}
