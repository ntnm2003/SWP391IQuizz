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
import swp391.quizpracticing.serviceimple.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
	@Autowired
	private ISliderService sliderService;

	@Autowired
	private IBlogService blogService;

//	@Autowired
//	private ISubjectOverviewService subjectOverviewService;

	@Autowired
	private ISubjectService subjectService;

	@GetMapping("/")
	public String redirectToHome() {
		return "redirect:/home";
	}

	@GetMapping("/home")
	public String getToHomePage(Model model, HttpSession session) {

		//Get sliders
		List<SliderDTO> sliders = sliderService.getAllSlidersForHomepage();
		//Get featured posts
		List<BlogDTO> blogs = blogService.getFeaturedPosts(true);
		//Get latest posts
		List<BlogDTO> latestPosts = blogService.getFeaturedLatestPosts(true, 2);

		//Get all subject overview by featuring
		List<SubjectOverview> featuredSubjectOverviews = subjectOverviewService.getSObyFeaturing("1");
		//export an array of featured subjects's ids
		List<Integer> featuredSubjectsIds = new ArrayList<>();
		for(SubjectOverview featuredSubjectOverview : featuredSubjectOverviews) {
			int id = featuredSubjectOverview.getIdOverview();
			featuredSubjectsIds.add(id);
		}
		//Get all subjects by id
		List<Subject> featuredSubjects = subjectService.findByFeaturing(featuredSubjectsIds);

		//Add to model
		model.addAttribute("sliders", sliders);
		model.addAttribute("blogs", blogs);
		model.addAttribute("lastestPosts", latestPosts);
		model.addAttribute("featuredSubjects", featuredSubjects);
		model.addAttribute("featuredSubjectOverviews", featuredSubjectOverviews);


		model.addAttribute("userSession", session.getAttribute("user"));


		return "homepage/homepage";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/home";
	}

}
