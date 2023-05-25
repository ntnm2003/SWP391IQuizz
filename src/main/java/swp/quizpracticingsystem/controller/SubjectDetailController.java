package swp.quizpracticingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import swp.quizpracticingsystem.model.SubjectOverview;
import swp.quizpracticingsystem.service.ISubjectOverviewService;

@Controller
public class SubjectDetailController {
    @Autowired
    private ISubjectOverviewService subjectOverviewService;

    @GetMapping("/subject/subject-detail/{id}")
    public String showSubjectDetails(@PathVariable("id") Integer id, Model model) {
        SubjectOverview subject = subjectOverviewService.getSubjectById(id);
        model.addAttribute("subject", subject);
        return "sub_details/sub_details";
    }
}
