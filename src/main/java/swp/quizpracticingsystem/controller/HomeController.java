package swp.quizpracticingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import swp.quizpracticingsystem.dto.PostsDTO;
import swp.quizpracticingsystem.dto.SliderDTO;
import swp.quizpracticingsystem.repository.IBlogRepository;
import swp.quizpracticingsystem.service.IBlogService;
import swp.quizpracticingsystem.service.ISliderSevice;
import swp.quizpracticingsystem.serviceImple.SliderService;

import java.util.List;

@Controller
public class HomeController {
	@Autowired
	private ISliderSevice sliderSevice;

	@Autowired
	private IBlogService blogService;

	@GetMapping("/home")
	public String getToHomePage(Model model) {
		//Get sliders
		List<SliderDTO> sliders = sliderSevice.getAllSlidersForHomepage();
		//Get featured posts
		List<PostsDTO> blogs = blogService.getFeaturedPosts(true);

		//Add to model
		model.addAttribute("sliders", sliders);
		model.addAttribute("blogs", blogs);

		System.out.println("Is the result list null? " + blogs.isEmpty());

		for(PostsDTO slider : blogs) {
			System.out.println(slider);
		}

		return "homepage/homepage";
	}

}
