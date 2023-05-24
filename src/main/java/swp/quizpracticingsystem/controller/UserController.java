package swp.quizpracticingsystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import swp.quizpracticingsystem.NotFound.MyRegistration;
import swp.quizpracticingsystem.NotFound.UserCourseKey;
import swp.quizpracticingsystem.model.Category;
import swp.quizpracticingsystem.model.Subject;
import swp.quizpracticingsystem.model.Usercourse;
import swp.quizpracticingsystem.service.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import swp.quizpracticingsystem.serviceImple.CategoryService;
import swp.quizpracticingsystem.serviceImple.PricePackageService;
import swp.quizpracticingsystem.serviceImple.SubjectService;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserCourseService userCourseService;
    private final SubjectService subService;
    private final PricePackageService packageService;
    private final CategoryService categoryService;

    private List<MyRegistration> reg(Integer id) {
        List<Subject> subjects = userCourseService.courseById(id);
        List<MyRegistration> regis = new ArrayList<>(Collections.nCopies(subjects.size(), null));
        List<Date> dateRegis = new ArrayList<>();
        List<String> status = new ArrayList<>();
        List<String> registationId = new ArrayList<>();
        List<Integer> price = new ArrayList<>();
        for (Usercourse uc : userCourseService.listAll()) {
            if (uc.getId().getUser_id().intValue() == id) {
                for (Subject sub : subjects) {
                    if (sub.getIdCourse().intValue() == uc.getId().getIdcourse().intValue()) {
                        dateRegis.add(uc.getDateRegister());
                        status.add(uc.getStatus());
                        registationId.add(uc.getId().toString());
                        price.add(uc.getPrice());
                        System.out.println("Test 1 "+uc.getPrice());
                    }
                }
            }
        }
        Calendar calendar = Calendar.getInstance();
        for (int i = 0; i < subjects.size(); i++) {
            MyRegistration r = new MyRegistration();
            r.setCid(subjects.get(i).getIdCourse());
            r.setSubName(subjects.get(i).getCourseName());
            r.setRegisId(registationId.get(i));
            r.setDateRegis(dateRegis.get(i));
            r.setStatus(status.get(i));
            r.setTotalcost(packageService.getById((Integer) price.get(i)).getSalePrice());
            r.setPackageName(packageService.getById((Integer) price.get(i)).getPackageName());

            Date date = dateRegis.get(i);
            calendar.setTime(date);
            calendar.add(Calendar.DATE, 90);
            date = new Date(calendar.getTimeInMillis());
            r.setValidTo(date);

            regis.set(i, r);
        }
        return regis;
    }

    @GetMapping("/users/myregistration/{id}")
    public String showRegistation(@PathVariable("id") Integer id, Model model) {
        List<MyRegistration> regis = reg(id);
        List<Subject> subjects = userCourseService.courseById(id);
        List<Category> cat = categoryService.listAll();
        model.addAttribute("sub", subjects);
        model.addAttribute("cat", cat);
        model.addAttribute("regis", regis);

        return "templates/my_registration";
    }

    @GetMapping("/users/myregistration/{uid}/{cid}")
    public String regisCourse(@PathVariable("uid") Integer uid, @PathVariable("cid") Integer cid, Model model) {
        List<MyRegistration> regis = reg(uid);
        List<Subject> sub = new ArrayList<>();
        for (MyRegistration r : regis) {
            if (r.getSubName().equals(subService.getById(cid).getCourseName())) {
                sub.add(subService.getById(cid));
            }
        }
        model.addAttribute("subj", sub);
        return "templates/subject_info";
    }

    @GetMapping("/users/registration/save/{user_id}/{course_id}")
    public ModelAndView saveRegistration(@PathVariable("user_id") Integer user_id, @PathVariable("course_id") Integer course_id,
                                         @RequestParam("button") Integer but,
                                         RedirectAttributes ra, ModelMap model) {
        Usercourse uc = new Usercourse();

        UserCourseKey uk = new UserCourseKey();
        uk.setIdcourse(course_id);
        uk.setUser_id(user_id);
        uc.setId(uk);
        LocalDate localDate = LocalDate.now();
        java.sql.Date sqlDate = java.sql.Date.valueOf(localDate);
        uc.setDateRegister(sqlDate);
        uc.setPrice(but);
        userCourseService.save(uc);
        ra.addFlashAttribute("message", "The user has been saved successfully.");
        return new ModelAndView("redirect:/home", model);
    }
//    @GetMapping("/users/myregistration/{id}/search")
//    public String search(
//
//    )


}
