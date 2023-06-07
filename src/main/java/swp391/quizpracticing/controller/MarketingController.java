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
import org.springframework.web.bind.annotation.*;
import swp391.quizpracticing.dto.SliderDTO;
import swp391.quizpracticing.model.Blog;
import swp391.quizpracticing.model.Slider;
import swp391.quizpracticing.repository.IBlogRepository;
import swp391.quizpracticing.service.ISliderService;

import java.util.List;
import java.util.Optional;

@Controller
public class MarketingController {
    @Autowired
    private ISliderService iSliderService;

    @GetMapping("/slider/sliders-list")
    public String getToSliderListPage(Model model) {
        List<SliderDTO> slider = (List<SliderDTO>) iSliderService.getAllSlider();
        model.addAttribute("slider", slider);
        return "marketing/sliders_list";
    }
    @GetMapping("/sliders-list")
    public String listByPage(@RequestParam(name = "page", required = false) Integer page, Model model, HttpSession session) {

        System.out.println("pageNum="+page);

        //Get Paginated Blogs with corresponding categories

        if (page == null) {
            //Get All post with their corresponding categories (with pagination)
                Page<Slider> sliderWithPagination = iSliderService.getAllSlidersWithPagination(0);
            model.addAttribute("sliders", sliderWithPagination);
            return "marketing/sliders_list";
        } else {
            Page<Slider> sliderWithPagination = iSliderService.getAllSlidersWithPagination(page - 1);
            model.addAttribute("sliders", sliderWithPagination);
        }
        return "marketing/sliders_list";
    }
    @GetMapping("/search")
    public String searchSlider(@RequestParam("searchTerm") String searchTerm, Model model, HttpSession session) {

        System.out.println("Call searchSlider() method!!!");

        if(searchTerm.isEmpty()) {
            return "redirect:/sliders-list";
        }

        //Search for posts
        List<SliderDTO> searchedSlider = iSliderService.searchByTitle(searchTerm);

        model.addAttribute("slider", searchedSlider);
        model.addAttribute("userSession", session.getAttribute("user"));

        return "marketing/sliders_list";
    }

//    @GetMapping("/filter")
//    public String filterSlider(@RequestParam("selectedStatus") List<String> selectedStatus, Model model, HttpSession session) {
//        //Find Selected Post Category by id
//        List<Slider> filterSlider = new ArrayList<>();
//        for(String selectedStatus : selectedStatus) {
//
//            if(selectedStatus.equals("0")) {
//                return "redirect:/sliders-list";
//            } else {
//                PostCategory postCategory = new PostCategory();
//                postCategory = iBlogCategoryService.findByPostCategoryId(Integer.parseInt(selectedCategory));
//                filteredCategories.add(postCategory);
//            }
//
//        }
//
//        //Get Filtered Posts by Selected Post Categories
//        List<PostsDTO> filteredPosts = iBlogService.getFilteredPosts(filteredCategories);
//
//        //Get all categories
//        List<PostCategoryDTO> postCategories = iBlogCategoryService.getAllCategories();
//
//        //Get latest blogs
//        List<PostsDTO> latestBlogs = iBlogService.getLatestPosts(2);
//
//        model.addAttribute("posts", filteredPosts);
//        model.addAttribute("postCategories", postCategories);
//        model.addAttribute("lastestBlogs", latestBlogs);
//
//        model.addAttribute("userSession", session.getAttribute("user"));
//        return "blogs_list/blogs_list";
//    }

    @Autowired
    private IBlogRepository iBlogRepository;

    @GetMapping("/blog/{id}")
    public String getBlogDetail(@PathVariable("id") Integer id, Model model) {
        Optional<Blog> optionalBlog = iBlogRepository.findById(id);
        if (optionalBlog.isPresent()) {
            Blog blog = optionalBlog.get();
            model.addAttribute("blog", blog);
            return "marketing/blog_list";
        } else {
            return "404";
        }
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        Optional<Blog> optionalBlog = iBlogRepository.findById(id);
        if (optionalBlog.isPresent()) {
            Blog blog = optionalBlog.get();
            model.addAttribute("blog", blog);
            return "marketing/blog_edit";
        } else {
            return "404";
        }
    }

    @PostMapping("/{id}/edit")
    public String editBlog(@PathVariable("id") Integer id, @ModelAttribute Blog updatedBlog) {
        Optional<Blog> optionalBlog = iBlogRepository.findById(id);
        if (optionalBlog.isPresent()) {
            Blog blog = optionalBlog.get();
            blog.setThumbnail(updatedBlog.getThumbnail());
            blog.setCategories(updatedBlog.getCategories());
            blog.setTitle(updatedBlog.getTitle());
            blog.setBriefInfo(updatedBlog.getBriefInfo());
            blog.setContent(updatedBlog.getContent());
            blog.setAuthor(updatedBlog.getAuthor());
            iBlogRepository.save(blog);
            return "redirect:/blog/" + id;
        } else {
            return "404";
        }
    }
}
