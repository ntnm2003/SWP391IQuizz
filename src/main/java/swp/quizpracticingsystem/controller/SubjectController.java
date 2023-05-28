/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp.quizpracticingsystem.controller;

import jakarta.servlet.http.HttpSession;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import swp.quizpracticingsystem.dto.CategoryDTO;
import swp.quizpracticingsystem.dto.SubjectDTO;
import swp.quizpracticingsystem.service.ICategoryService;
import swp.quizpracticingsystem.service.IPricePackageService;
import swp.quizpracticingsystem.service.ISubjectOverviewService;
import swp.quizpracticingsystem.service.ISubjectService;

/**
 *
 * @author Mosena
 */
@Controller
public class SubjectController {
    
    @Autowired
    private ISubjectService subjectService;
    
    @Autowired
    private ICategoryService categoryService;
    
    @Autowired
    private IPricePackageService pricePackageService;
    
    @Autowired
    private ISubjectOverviewService subjectOverviewService;
    
    @GetMapping("/subjects/subjects-list")
    public String getAllSubject(
            @RequestParam(value="pageNo",defaultValue = "1") int pageNo,
            @RequestParam(value="category",required = false) Integer categoryId,
            @RequestParam(value="sortBy",required=false) String sortBy,
            @RequestParam(value="order", required=false) String order,
            Model model, HttpSession session){
        Page<SubjectDTO> subjects;
        System.out.println("category "+categoryId+" sortBy "+sortBy+" order "+order);
        if(categoryId!=null && sortBy==null && order==null){
            subjects=subjectService.filterSubjectByCategory(pageNo, 
                    8, categoryId);
        }
        else if(categoryId==null && sortBy!=null && order!=null){
            subjects=subjectService.sortSubjectBy(pageNo, 1, 
                                sortBy, order);
        }
        else if(categoryId!=null && sortBy!=null && order!=null){
            subjects=subjectService.filterAndSortSubject(pageNo, 1, 
                    categoryId, sortBy, order);
        }
        else{
            subjects=subjectService
                .findPaginatedAllSubjects(pageNo, 1);
        }
        List<CategoryDTO> listCategory=categoryService.findAll();
        for(SubjectDTO subject:subjects){
            String description=subjectOverviewService
                    .getSubjectById(subject.getIdCourse())
                    .getDescription();
            Integer lowestPrice=pricePackageService
                    .findMinPricePackage(subject.getIdCourse())
                    .getSalePrice();
            model.addAttribute("subjectDesc_"+subject.getIdCourse(), 
                    description);
            model.addAttribute("subjectPrice_"+subject.getIdCourse(), 
                    lowestPrice);
        }
        model.addAttribute("category", categoryId);
        model.addAttribute("subjects", subjects);
        model.addAttribute("sortBy",sortBy);
        model.addAttribute("order",order);
        model.addAttribute("categories", listCategory);
        model.addAttribute("pageNo", pageNo);
        model.addAttribute("totalPages"
                , subjects.getTotalPages());
        model.addAttribute("totaSubjects"
                , subjects.getTotalElements());
        model.addAttribute("userSession",session.getAttribute("user"));
        return "subjects_list/subjects";
    }
    
    @GetMapping("/subjects/subjects-list/search")
    public String searchSubject(
            @RequestParam(value="searchValue", required = true) String searchValue,
            @RequestParam(value="pageNo",defaultValue = "1") int pageNo,
            @RequestParam(value="category",required = false) Integer categoryId,
            @RequestParam(value="sortBy",required=false) String sortBy,
            @RequestParam(value="order", required=false) String order,
            Model model, HttpSession session){
        Page<SubjectDTO> subjects;
        if(categoryId!=null && sortBy==null && order==null){
            subjects=subjectService.findSubjectNameAndFilter(pageNo, 1, 
                    searchValue, categoryId);
        }
        else if(categoryId==null && sortBy!=null && order!=null){
            subjects=subjectService.searchAndSortSubject(pageNo, 1, 
                    searchValue, sortBy, order);
        }
        else if(categoryId!=null && sortBy!=null && order!=null){
            subjects=subjectService.filterAndSearchAndSortSubject(pageNo,
                    1, categoryId, searchValue,
                    sortBy, order);
        }
        else{
            subjects=subjectService
                .findSubjectBySubjectName(pageNo, 1, searchValue);
        }
        List<CategoryDTO> listCategory=categoryService.findAll();
        for(SubjectDTO subject:subjects){
            String description=subjectOverviewService
                    .getSubjectById(subject.getIdCourse())
                    .getDescription();
            Integer lowestPrice=pricePackageService
                    .findMinPricePackage(subject.getIdCourse())
                    .getSalePrice();
            model.addAttribute("subjectDesc_"+subject.getIdCourse(), 
                    description);
            model.addAttribute("subjectPrice_"+subject.getIdCourse(), 
                    lowestPrice);
        }
        model.addAttribute("searchValue", searchValue);
        model.addAttribute("category", categoryId);
        model.addAttribute("subjects", subjects);
        model.addAttribute("categories", listCategory);
        model.addAttribute("pageNo", pageNo);
        model.addAttribute("totalPages"
                , subjects.getTotalPages());
        model.addAttribute("totaSubjects"
                , subjects.getTotalElements());
        model.addAttribute("userSession",session.getAttribute("user"));
        return "subjects_list/subjects-search";
    }
}
