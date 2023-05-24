package swp.quizpracticingsystem.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import swp.quizpracticingsystem.model.User;
import swp.quizpracticingsystem.service.LoginService;

@Controller
public class LoginController {

    @Autowired
    LoginService userService;

    @GetMapping("/login")
    public String login(HttpSession session) {
        if (session.getAttribute("user") != null) {
            return "homepage/homepage";
        } else {
            return "login/login";
        }
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, HttpSession session, Model model) {
        User account = userService.login(user);
        if (account == null) {
            model.addAttribute("message", "Invalid password or email");
            return "login/login";
        } else if(account.isEnabled() == false){
            model.addAttribute("message", "Account is not verify!");
            return "login/login";
        } else {
            session.setAttribute("user", account);
            return "homepage/homepage";
        }
    }

}
