package swp.quizpracticingsystem.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import swp.quizpracticingsystem.model.User;
import swp.quizpracticingsystem.service.UserService;

@Controller
public class LoginController {

    @Autowired
    UserService userService;


    @GetMapping("/login")
    public String login() {
        return "login/login";
    }
    @PostMapping("/login")
    public String login(HttpServletRequest request, HttpSession session) {
        User account = userService.login(request.getParameter("email"), request.getParameter("password"));
        if(account == null) {
            session.setAttribute("message", "Invalid email or password");
            return "login/login";
        }else {
            session.setAttribute("user", account);
            return "home/homepage/homepage";
        }
    }

}
