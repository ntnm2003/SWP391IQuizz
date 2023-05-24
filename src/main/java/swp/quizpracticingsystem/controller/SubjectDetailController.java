package swp.quizpracticingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import swp.quizpracticingsystem.model.Posts;
import swp.quizpracticingsystem.model.Subject;
import swp.quizpracticingsystem.model.SubjectDetail;
import swp.quizpracticingsystem.service.ISubjectDetailService;

import java.util.Optional;
@Controller
public class SubjectDetailController {
    @Autowired
    private ISubjectDetailService subjectDetailService;

    @GetMapping("/subject/subject-detail/{id}")
    public String showSubjectDetails(@PathVariable("id") Integer id, Model model) {
        Subject subject = subjectDetailService.getSubjectById(id);
        model.addAttribute("subject", subject);
        return "sub_details/sub_details";
    }
}
