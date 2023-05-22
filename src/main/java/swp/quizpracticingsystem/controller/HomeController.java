package swp.quizpracticingsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
	@GetMapping("/home")
	public String getToHomePage() {
		return "home/homepage/homepage";
	}
}
