/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp.quizpracticingsystem.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import swp.quizpracticingsystem.model.User;

/**
 *
 * @author Lenovo
 */
@Controller
public class ProfileController {
    @GetMapping("/profile")
    public String MyProfile(@RequestParam("userid") String userId, Model model, HttpSession session) {  
        User user =(User) session.getAttribute("user");
        model.addAttribute("user", user);
        return "myprofile/MyProfile";
    }
    
}
