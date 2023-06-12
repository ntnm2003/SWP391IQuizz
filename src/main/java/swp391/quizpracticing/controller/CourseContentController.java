/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp391.quizpracticing.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import swp391.quizpracticing.model.User;

/**
 *
 * @author Mosena
 */
@Controller
public class CourseContentController {

    @GetMapping("admin/subjects-list")
    public String AdminGetToSubjectsList(Model model, HttpSession session) {

        User loggedinUser = (User)session.getAttribute("user");

        model.addAttribute("userSession", session.getAttribute("user"));

        return "course_content/subjects-list";
    }

    @GetMapping("expert/subjects-list")
    public String ExpertGetToSubjectsList(Model model, HttpSession session) {

        return "course_content/subjects-list";
    }
    
}
