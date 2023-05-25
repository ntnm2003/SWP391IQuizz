package swp.quizpracticingsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import swp.quizpracticingsystem.dto.PostsDTO;
import swp.quizpracticingsystem.model.Posts;
import swp.quizpracticingsystem.service.IBlogService;

@Controller
@RequestMapping("/blogs")
public class BlogController {
	
	@Autowired
	private IBlogService blogService;

	@GetMapping("/blogs-list")
	public String getToBlogsListPage(Model model) {
		List<PostsDTO> blogs = (List<PostsDTO>) blogService.getAllBlogs();
		model.addAttribute("blogs", blogs);
		return "blogs_list/blogs_list";
	}
}
