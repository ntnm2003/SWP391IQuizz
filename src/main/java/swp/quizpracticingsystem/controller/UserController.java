package swp.quizpracticingsystem.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import swp.quizpracticingsystem.model.User;

@Controller
public class UserController {

    @Autowired
    
    @GetMapping("/register")
    public String register() {
        return "home/register";
    }

    @GetMapping("/login")
    public String login() {
        return "home/login";
    }

}
