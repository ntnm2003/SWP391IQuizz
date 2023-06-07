package swp391.quizpracticing.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import swp391.quizpracticing.model.User;
import swp391.quizpracticing.service.LoginService;

@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping("/loginn")
        public String signinPage(WebRequest request, Model model) {
            return "common/login";
        }

    @PostMapping("/loginn")
    public String login(@ModelAttribute User user, HttpSession session, Model model) {
        User account = loginService.login(user);
        if (account == null) {
            model.addAttribute("message", "Invalid password or email");
            return "common/login";
        } else if(!account.getEnable()){
            model.addAttribute("message", "Account is not verify!");
            return "common/login";
        } else {
            return "redirect:/home";
        }
    }

}
