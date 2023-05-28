package swp.quizpracticingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import swp.quizpracticingsystem.model.Posts;
import swp.quizpracticingsystem.service.IBlogDetailService;


@Controller
public class BlogDetailController {
    @Autowired
    private IBlogDetailService blogDetailService;


    @GetMapping("/blogs/blog-detail/{id}")
    public String showBlogDetails(@PathVariable("id") Integer id, Model model) {
        Posts blogs = blogDetailService.getPostById(id);
        model.addAttribute("blogs", blogs);
        return "blog_details/blog_details";
    }

}
