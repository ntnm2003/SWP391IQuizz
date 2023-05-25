package swp.quizpracticingsystem.controller;

import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import swp.quizpracticingsystem.dto.PostCategoryDTO;
import swp.quizpracticingsystem.dto.PostsDTO;
import swp.quizpracticingsystem.model.PostCategory;
import swp.quizpracticingsystem.model.Posts;
import swp.quizpracticingsystem.repository.IBlogCategoryRepository;
import swp.quizpracticingsystem.service.IBlogCategoryService;
import swp.quizpracticingsystem.service.IBlogService;

@Controller

public class BlogsListController {

	@Autowired
	private IBlogService iBlogService;

	@Autowired
	private IBlogCategoryService iBlogCategoryService;

	@GetMapping("/blogs-list")
	public String getToBlogsListPage(Model model, HttpSession session) {
		//Get All post with their corresponding categories (with pagination)
		Page<Posts> postsWithPagination = iBlogService.getAllPostsWithPagination(0);
		//Get latest blogs
		List<PostsDTO> latestBlogs = iBlogService.getLatestPosts(1);
		//Get all categories
		List<PostCategoryDTO> postCategories = iBlogCategoryService.getAllCategories();
		//Get Paginated Blogs with corresponding categories


		//Add to model
		model.addAttribute("posts", postsWithPagination);
		model.addAttribute("lastestBlogs", latestBlogs);
		model.addAttribute("postCategories", postCategories);


		model.addAttribute("userSession", session.getAttribute("user"));

		return "blogs_list/blogs_list";
	}

	@GetMapping("/blogs-list/{pageNum}")
	public String listByPage(@PathVariable(name = "pageNum") int pageNum, Model model) {
		Page<Posts> postsWithPagination = iBlogService.getAllPostsWithPagination(pageNum-1);

		//Get latest blogs
		List<PostsDTO> latestBlogs = iBlogService.getLatestPosts(2);
		//Get all categories
		List<PostCategoryDTO> postCategories = iBlogCategoryService.getAllCategories();
		//Get Paginated Blogs with corresponding categories

		//Add to model
		model.addAttribute("posts", postsWithPagination);
		model.addAttribute("lastestBlogs", latestBlogs);
		model.addAttribute("postCategories", postCategories);
		return "blogs_list/blogs_list";
	}

	@GetMapping("/search")
	public String searchPosts(@RequestParam("searchTerm") String searchTerm, Model model, HttpSession session) {

		System.out.println("Call searchPosts() method!!!");

		if(searchTerm.isEmpty()) {
			return "redirect:/blogs/blogs-list";
		}

		//Get all categories
		List<PostCategoryDTO> postCategories = iBlogCategoryService.getAllCategories();

		//Search for posts
		List<PostsDTO> searchedPosts = iBlogService.searchByTitle(searchTerm);

		//Get latest blogs
		List<PostsDTO> latestBlogs = iBlogService.getLatestPosts(2);

		model.addAttribute("posts", searchedPosts);
		model.addAttribute("postCategories", postCategories);
		model.addAttribute("lastestBlogs", latestBlogs);

		model.addAttribute("userSession", session.getAttribute("user"));


		return "blogs_list/blogs_list";
	}


	@GetMapping("/filter")
	public String filterPosts(@RequestParam("selectedCategories") List<String> selectedCategories, Model model, HttpSession session) {
		//Find Selected Post Category by id
		List<PostCategory> filteredCategories = new ArrayList<>();
		for(String selectedCategory : selectedCategories) {

			if(selectedCategory.equals("0")) {
				return "redirect:/blogs/blogs-list";
			}
			else {
				PostCategory postCategory = new PostCategory();
				postCategory = iBlogCategoryService.findByPostCategoryId(Integer.parseInt(selectedCategory));
				filteredCategories.add(postCategory);
			}

		}

		//Get Filtered Posts by Selected Post Categories
		List<PostsDTO> filteredPosts = iBlogService.getFilteredPosts(filteredCategories);

		//Get all categories
		List<PostCategoryDTO> postCategories = iBlogCategoryService.getAllCategories();

		//Get latest blogs
		List<PostsDTO> latestBlogs = iBlogService.getLatestPosts(2);

		model.addAttribute("posts", filteredPosts);
		model.addAttribute("postCategories", postCategories);
		model.addAttribute("lastestBlogs", latestBlogs);

		model.addAttribute("userSession", session.getAttribute("user"));
		return "blogs_list/blogs_list";
	}

}
