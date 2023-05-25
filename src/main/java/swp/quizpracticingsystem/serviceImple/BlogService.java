package swp.quizpracticingsystem.serviceImple;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import swp.quizpracticingsystem.dto.PostsDTO;
import swp.quizpracticingsystem.model.PostCategory;
import swp.quizpracticingsystem.model.Posts;
import swp.quizpracticingsystem.repository.IBlogRepository;
import swp.quizpracticingsystem.service.IBlogService;

@Service
public class BlogService implements IBlogService {

	public static final int POSTS_PER_PAGE = 4;
	
	@Autowired
	private IBlogRepository iBlogRepository;

	@Override
	public List<PostsDTO> getAllBlogs() {
		List<PostsDTO> results = new ArrayList<>();
		List<Posts> posts = iBlogRepository.findAll();
		for(Posts post : posts) {
			PostsDTO postsDTO = new PostsDTO();
			postsDTO.postsHomePage(post);
			results.add(postsDTO);
		}
		return results;
	}

	@Override
	public List<PostsDTO> getFeaturedPosts(boolean isFeatured) {
		List<Posts> featuredPosts = iBlogRepository.findByFeaturing(isFeatured);
		List<PostsDTO> results = new ArrayList<>();
		for(Posts post : featuredPosts) {
			PostsDTO postsDTO = new PostsDTO();
			postsDTO.postsHomePage(post);
			results.add(postsDTO);
		}
		return results;
	}

	@Override
	public List<PostsDTO> getFeaturedLatestPosts(boolean isFeatured, int limit) {
		List<Posts> lastestPosts = iBlogRepository.findByFeaturingOrderByUpdatedDate(isFeatured, limit);
		List<PostsDTO> results = new ArrayList<>();
		for(Posts post : lastestPosts) {
			PostsDTO postsDTO = new PostsDTO();
			postsDTO.postsHomePage(post);
			results.add(postsDTO);
		}
		return results;

	}

	@Override
	public List<PostsDTO> getLatestPosts(int limit) {
		List<Posts> lastestPosts = iBlogRepository.findByUpdatedDate(limit);
		List<PostsDTO> results = new ArrayList<>();
		for(Posts post : lastestPosts) {
			PostsDTO postsDTO = new PostsDTO();
			postsDTO.postsHomePage(post);
			results.add(postsDTO);
		}
		return results;
	}

	@Override
	public Page<Posts> getAllPostsWithPagination(int pageNo) {
//		Pageable pageable = PageRequest.of(pageNo, pageSize);
		Page<Posts> posts = iBlogRepository.findAll(PageRequest.of(pageNo, POSTS_PER_PAGE));

		return posts;
	}

	@Override
	public List<PostsDTO> searchByTitle(String searchTerm) {
		List<PostsDTO> results = new ArrayList<>();
		List<Posts> searchedPosts = iBlogRepository.findByTitleContainingIgnoreCase(searchTerm);
		for(Posts post : searchedPosts) {
			PostsDTO postsDTO = new PostsDTO();
			postsDTO.postsHomePage(post);
			results.add(postsDTO);
		}
		return results;
	}

	@Override
	public List<PostsDTO> getFilteredPosts(List<PostCategory> categories) {
		List<Posts> filteredPosts = iBlogRepository.findByPostCategoryIn(categories);
		List<PostsDTO> results = new ArrayList<>();
		for(Posts post : filteredPosts) {
			PostsDTO postsDTO = new PostsDTO();
			postsDTO.postsHomePage(post);
			results.add(postsDTO);
		}

		return results;
	}


}
