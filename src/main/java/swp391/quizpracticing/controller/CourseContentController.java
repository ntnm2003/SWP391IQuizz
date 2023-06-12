/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp391.quizpracticing.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import swp391.quizpracticing.model.Subject;
import swp391.quizpracticing.model.User;
import swp391.quizpracticing.service.ISubjectService;

/**
 *
 * @author Mosena
 */
@Controller
public class CourseContentController {

    @Autowired
    private ISubjectService iSubjectService;

    @GetMapping("admin/subjects-list")
    public String AdminGetToSubjectsList(@RequestParam(name = "pageNum", defaultValue = "0") Integer pageNum, @RequestParam(name = "itemPerPage", defaultValue = "10") Integer itemPerPage, Model model, HttpSession session) {

        System.out.println("itemPerPage: " + itemPerPage);

        User loggedinUser = (User)session.getAttribute("user");

        Page<Subject> subjectsWithPagination = iSubjectService.findSubjectsWithPagination(pageNum, itemPerPage);
        System.out.println(subjectsWithPagination.getSize());
        System.out.println("totalPages: " + subjectsWithPagination.getTotalPages());
        System.out.println("hasPrevious: " + subjectsWithPagination.hasPrevious());

        model.addAttribute("userSession", session.getAttribute("user"));
        model.addAttribute("subjects", subjectsWithPagination);
        model.addAttribute("currentPage", pageNum);
        model.addAttribute("selectedItemPerPage", itemPerPage);

        return "course_content/subjects-list";
    }

    @GetMapping("expert/subjects-list")
    public String ExpertGetToSubjectsList(Model model, HttpSession session) {

        User loggedinUser = (User)session.getAttribute("user");

        model.addAttribute("userSession", session.getAttribute("user"));

        return "course_content/subjects-list";

    }
    
}
