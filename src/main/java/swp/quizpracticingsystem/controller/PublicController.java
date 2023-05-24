package swp.quizpracticingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import swp.quizpracticingsystem.NotFound.UserCourseKey;
import swp.quizpracticingsystem.model.PricePackage;
import swp.quizpracticingsystem.model.Subject;
import swp.quizpracticingsystem.model.Usercourse;
import swp.quizpracticingsystem.service.UserCourseService;

import java.util.List;
import swp.quizpracticingsystem.serviceImple.PricePackageService;
import swp.quizpracticingsystem.serviceImple.SubjectService;
@Controller
public class PublicController {
    @Autowired
    private UserCourseService userCourseService;
    @Autowired private SubjectService subService;
    @Autowired private PricePackageService packageService;

    @GetMapping("/registration/{course_id}")
    public String registerSubject(@PathVariable("course_id") Integer course_id, Model model) {
        Subject su = subService.getById(course_id);
        List<PricePackage> price = packageService.getBySubject(course_id);
        model.addAttribute("sub",su);
        model.addAttribute("pack", price);
        return "templates/subject_register";
    }
    @GetMapping("/registration/{course_id}/{user_id}")
    public String registerSubject(@PathVariable("course_id") Integer course_id, @PathVariable("user_id") Integer user_id, Model model) {

        Subject su = subService.getById(course_id);
        List<PricePackage> price = packageService.getBySubject(course_id);
        List<Subject> subjects;
            model.addAttribute("su", su);

            UserCourseKey uk = new UserCourseKey();

            PricePackage p;
            if (user_id == null) {

            } else {
                uk.setUser_id(user_id);
                uk.setIdcourse(course_id);
                Usercourse u = new Usercourse();
                subjects = userCourseService.courseById(user_id);
                    u = userCourseService.getId(uk);
                if (u==null){
                    u= new Usercourse();
                }
                p = packageService.getById(u.getId().getUser_id());
                model.addAttribute("u", u);

                p = new PricePackage();
            }
            model.addAttribute("sub", su);
            model.addAttribute("pack", price);
            return "templates/subject_register";
    }

}
