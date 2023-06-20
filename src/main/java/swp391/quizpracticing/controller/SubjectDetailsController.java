package swp391.quizpracticing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import swp391.quizpracticing.dto.DimensionDTO;
import swp391.quizpracticing.model.Pricepackage;
import swp391.quizpracticing.model.Subject;
import swp391.quizpracticing.service.IDimensionService;
import swp391.quizpracticing.service.IPricepackageService;
import swp391.quizpracticing.service.ISubjectService;

@Controller
public class SubjectDetailsController {
    @Autowired
    private ISubjectService subjectService;

    @GetMapping("/subject/subject-details")
    public String showSubjectDetails(@RequestParam(name = "id", required = true) Integer id, Model model) {
        Subject subject = subjectService.getSubjectById(id);
        model.addAttribute("subject", subject);
        return "admin/subjectdetails";
    }

    @GetMapping("/subject/subject-details-edit")
    public String editSubjectDetails(@RequestParam(name = "id", required = true) Integer id, Model model) {
        Subject subject = subjectService.getSubjectById(id);
        model.addAttribute("subject", subject);
        return "admin/subjectdetailsedit";
    }

    @Autowired
    private IDimensionService dimensionService;

    @GetMapping("/subject/dimension")
    public String getToDimensionListPage(Model model) {
        List<DimensionDTO> dimension = (List<DimensionDTO>) dimensionService.getAllDimension();
        model.addAttribute("dimension", dimension);
        return "admin/dimension";
    }

    @Autowired
    private IPricepackageService pricepackageService;

    @GetMapping("/subject/pricepackage")
    public String showPricepackage(@RequestParam(name = "sid", required = true) Integer sid, Model model) {
        Pricepackage pricepackage = pricepackageService.getPricepackageBySubId(sid);
        model.addAttribute("pricepackage", pricepackage);
        return "admin/pricepackage";
    }
}

