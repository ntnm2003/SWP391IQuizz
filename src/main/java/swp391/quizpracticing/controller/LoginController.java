package swp391.quizpracticing.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import swp391.quizpracticing.model.User;
import swp391.quizpracticing.service.LoginService;

@Controller
public class LoginController {

    @Autowired
    LoginService userService;

    @GetMapping("/login")
    public String login(HttpSession session) {
        if (session.getAttribute("user") != null) {
            return "redirect:/home";
        } else {
            return "common/login";
        }
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, HttpSession session, Model model) {
        User account = userService.login(user);
        if (account == null) {
            model.addAttribute("message", "Invalid password or email");
            return "common/login";
        } else if(account.getEnable() == false){
            model.addAttribute("message", "Account is not verify!");
            return "common/login";
        } else {
            session.setAttribute("user", account);
            return "redirect:/home";
        }
    }

}
