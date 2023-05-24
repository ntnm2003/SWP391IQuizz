package swp.quizpracticingsystem.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import swp.quizpracticingsystem.dto.PostsDTO;
import swp.quizpracticingsystem.dto.SliderDTO;
import swp.quizpracticingsystem.model.Subject;
import swp.quizpracticingsystem.model.SubjectDetail;
import swp.quizpracticingsystem.model.SubjectOverview;
import swp.quizpracticingsystem.model.User;
import swp.quizpracticingsystem.repository.IBlogRepository;
import swp.quizpracticingsystem.service.*;
import swp.quizpracticingsystem.serviceImple.SliderService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
	@Autowired
	private ISliderSevice sliderSevice;

	@Autowired
	private IBlogService blogService;

	@Autowired
	private ISubjectDetailService subjectDetailService;

	@Autowired
	private ISubjectOverviewService subjectOverviewService;

	@Autowired
	private ISubjectService subjectService;
        @GetMapping("/")
        public String redirectToHome() {
            return "redirect:/home";
        }
	@GetMapping("/home")
	public String getToHomePage(Model model, HttpSession session) {


		//Get sliders
		List<SliderDTO> sliders = sliderSevice.getAllSlidersForHomepage();
		//Get featured posts
		List<PostsDTO> blogs = blogService.getFeaturedPosts(true);
		//Get latest posts
		List<PostsDTO> latestPosts = blogService.getFeaturedLatestPosts(true, 2);

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

		//Testing
		System.out.println("Is the featured subjects list null? " + featuredSubjects.isEmpty());
		System.out.println("Is the featured subject overviews list null? " + featuredSubjectOverviews.isEmpty());

		for(int i = 0; i < featuredSubjects.size(); i++) {
			System.out.println("Subject name: " + featuredSubjects.get(i).getCourseName());
			System.out.println("Subject thumbnail: " + featuredSubjectOverviews.get(i).getImage());
			System.out.println("Subject tag line: " + featuredSubjectOverviews.get(i).getTagLine());
		}

		//Add to model
		model.addAttribute("sliders", sliders);
		model.addAttribute("blogs", blogs);
		model.addAttribute("lastestPosts", latestPosts);
		model.addAttribute("featuredSubjects", featuredSubjects);
		model.addAttribute("featuredSubjectOverviews", featuredSubjectOverviews);




		//Testing Session
		User user = new User();
		user.setFullName("Nguyen Anh Quan");
		user.setUserId(1);
		session.setAttribute("user", user);
		System.out.println(session.getAttribute("user") == null);


		model.addAttribute("userSession", session.getAttribute("user"));


		return "homepage/homepage";
	}

}
