package swp391.quizpracticing.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import swp391.quizpracticing.dto.BlogDTO;
import swp391.quizpracticing.dto.SliderDTO;
import swp391.quizpracticing.model.Subject;
import swp391.quizpracticing.model.*;
import swp391.quizpracticing.repository.*;
import swp391.quizpracticing.service.*;
import java.util.List;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

	@Autowired
	private ISliderService sliderService;

	@Autowired
	private IBlogService blogService;

	@Autowired
	private ISubjectService subjectService;

	@Autowired
	private IUserRepository iUserRepository;
        
        @Autowired
        private PasswordEncoder passwordEncoder;

	@GetMapping("/")
	public String redirectToHome() {
		return "redirect:/home";
	}

	@GetMapping("/home")
	public String getToHomePage(Model model, @Autowired HttpSession session) {

		//Get sliders
		List<SliderDTO> sliders = sliderService.getAllSlidersForHomepage();
		System.out.println("sliders size: " + sliders.size());

		//Get featured posts
		List<BlogDTO> blogs = blogService.getFeaturedBlog(true);
		System.out.println("blogs size: " + blogs.size());

		//Get latest posts
		List<BlogDTO> latestBlogs = blogService.getFeaturedLatestBlog(true, 2);
		System.out.println("latest blogs size: " + latestBlogs.size());

		//Get all Featured Subjects
		List<Subject> featuredSubjects = subjectService.findByFeaturing(true);
		System.out.println("featured subjects size: " + featuredSubjects.size());

		//Add to model
		model.addAttribute("sliders", sliders);
		model.addAttribute("blogs", blogs);
		model.addAttribute("latestBlogs", latestBlogs);
		model.addAttribute("featuredSubjects", featuredSubjects);

		model.addAttribute("userSession", session.getAttribute("user"));
		return "homepage/homepage";
	}

	@GetMapping("/logout")
	public String logout(Model model, HttpSession session) {

		session.invalidate();
		return "redirect:/home";

	}
}
