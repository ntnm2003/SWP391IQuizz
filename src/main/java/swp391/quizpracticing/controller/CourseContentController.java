/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp391.quizpracticing.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import swp391.quizpracticing.model.Category;
import swp391.quizpracticing.model.Subcategory;
import swp391.quizpracticing.model.Subject;
import swp391.quizpracticing.model.User;
import swp391.quizpracticing.repository.ISubjectRepository;
import swp391.quizpracticing.repository.IUserRepository;
import swp391.quizpracticing.service.ICategoryService;
import swp391.quizpracticing.service.ISubcategoryService;
import swp391.quizpracticing.service.ISubjectService;
import swp391.quizpracticing.service.IUserService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 *
 * @author Mosena
 */
@Controller
public class CourseContentController {

    @Autowired
    private ISubjectService iSubjectService;

    @Autowired
    private ISubcategoryService iSubcategoryService;

    @Autowired
    private ICategoryService iCategoryService;

    @Autowired
    private IUserService iUserService;

    @Autowired
    private ISubjectRepository iSubjectRepository;

    private final String FOLDER_PATH = "C:/Users/DELL/Documents/2_CodingZone/2_InSchool_(FPTUni)/5_SWP391/SWP391GitProject/summer2023-swp391.se1714-g5/src/main/resources/static/database_images";

    @GetMapping("admin/subjects-list")
    public String AdminGetToSubjectsList(@RequestParam(name = "pageNum", defaultValue = "0") Integer pageNum,
                                         @RequestParam(name = "itemPerPage", defaultValue = "10") Integer itemPerPage,
                                         @RequestParam(name = "subject-name", defaultValue = "") String searchTerm,
                                         @RequestParam(name = "category-id", defaultValue = "-1") Integer categoryId,
                                         @RequestParam(name = "status", defaultValue = "-1") String status,
                                         @RequestParam(name = "check", defaultValue = "false") Boolean check,
                                         Model model, HttpSession session) {

        System.out.println("check: " + check);
        if(check != null) {
            model.addAttribute("check", check);
        }


        User loggedinUser = (User)session.getAttribute("user");

        //Get all categories and subcategories and status
        List<Subcategory> allSubcategories = iSubcategoryService.getAll();

        List<Category> allCategories = iCategoryService.listAll();

        List<Subject> allSubjects = iSubjectService.listAll();

        Set<Boolean> allStatus = new HashSet<>();
        for(Subject subject : allSubjects) {
            allStatus.add(subject.getStatus());
        }

        if(searchTerm.isEmpty() && categoryId == -1 && status.equals("-1")) {  // display all subjects (no search, no filter)
            Page<Subject> subjectsWithPagination = iSubjectService.findSubjectsWithPagination(pageNum, itemPerPage);

            if(!subjectsWithPagination.hasContent()) {
                subjectsWithPagination = iSubjectService.findSubjectsWithPagination(0, itemPerPage);
            }

            model.addAttribute("subjects", subjectsWithPagination);

        } else if(!searchTerm.isEmpty()) {  // perform searching
            Page<Subject> subjectsWithPagination = iSubjectService.searchForSubjectsByName(pageNum, itemPerPage, searchTerm);
            System.out.println("number of subjects = " + subjectsWithPagination.getTotalElements());

            model.addAttribute("subjects", subjectsWithPagination);
        } else {  //Perform filtering

            Page<Subject> subjectsWithPagination;

            if(!status.equals("-1") && categoryId == -1) {  //filter by status
                subjectsWithPagination = iSubjectService.findSubjectsByStatus(Boolean.valueOf(status), pageNum, itemPerPage);
                model.addAttribute("subjects", subjectsWithPagination);
            }
            if(status.equals("-1") && categoryId != -1) {  //filter by catecory_id
                //Take all subjects + loop through all the subjects and get its list of subcategories
                //loop through received sub-categories and get + get categories from the subcategories list
                HashMap<Integer, Subject> map = new HashMap<>();
                for(Subject subject : allSubjects) {
                    List<Subcategory> subcategories = subject.getSubCategories();
                    for(Subcategory subcategory : subcategories) {
                        if(Objects.equals(subcategory.getCategory().getId(), categoryId)) {
                            if(!map.containsKey(subject.getId())) {
                                map.put(subject.getId(), subject);
                            }
                        }
                    }
                }

                List<Subject> filteredSubjects = new ArrayList<>(map.values());
                int totalSubjects = filteredSubjects.size();
                subjectsWithPagination = new PageImpl<>(filteredSubjects, PageRequest.of(pageNum, itemPerPage), totalSubjects);

                model.addAttribute("subjects", subjectsWithPagination);
            }
            if (!status.equals("-1") && categoryId != -1) {  //filter by both
                //Take all subjects + loop through all the subjects and get its list of subcategories
                //loop through received sub-categories and get + get categories from the subcategories list
                HashMap<Integer, Subject> map = new HashMap<>();
                for(Subject subject : allSubjects) {
                    List<Subcategory> subcategories = subject.getSubCategories();
                    for(Subcategory subcategory : subcategories) {
                        if(Objects.equals(subcategory.getCategory().getId(), categoryId)) {
                            if(!map.containsKey(subject.getId())) {
                                map.put(subject.getId(), subject);
                            }
                        }
                    }
                }

                List<Subject> filteredSubjects = new ArrayList<>();
                for(Subject subject : map.values()) {
                    if(subject.getStatus() == Boolean.parseBoolean(status)) {
                        filteredSubjects.add(subject);
                    }
                }
                int totalSubjects = filteredSubjects.size();
                subjectsWithPagination = new PageImpl<>(filteredSubjects, PageRequest.of(pageNum, itemPerPage), totalSubjects);

                model.addAttribute("subjects", subjectsWithPagination);
            }
        }

        model.addAttribute("userSession", session.getAttribute("user"));
        model.addAttribute("subjectName", searchTerm);
        model.addAttribute("pageNum", pageNum);
        model.addAttribute("itemPerPage", itemPerPage);
        model.addAttribute("selectedItemPerPage", itemPerPage);
        model.addAttribute("categories", allCategories);
        model.addAttribute("categoryId", categoryId);
        model.addAttribute("allStatus", allStatus);
        model.addAttribute("selectedStatus", status);

        return "course_content/subjects-list";
    }

    @GetMapping("expert/subjects-list")
    public String ExpertGetToSubjectsList(@RequestParam(name = "pageNum", defaultValue = "0") Integer pageNum,
                                          @RequestParam(name = "itemPerPage", defaultValue = "10") Integer itemPerPage,
                                          @RequestParam(name = "subject-name", defaultValue = "") String searchTerm,
                                          @RequestParam(name = "category-id", defaultValue = "-1") Integer categoryId,
                                          @RequestParam(name = "status", defaultValue = "-1") String status,
                                          @RequestParam(name = "check") Boolean check,
                                          Model model, HttpSession session) {

        User loggedinUser = (User)session.getAttribute("user");

        //Find subjects by expert_id
        Page<Subject> subjectsWithPaginationByExpertId = iSubjectService.findSubjectsWithPaginationByExpertId(loggedinUser.getId(), pageNum, itemPerPage);

        Set<Boolean> allStatus = new HashSet<>();
        for(Subject subject : subjectsWithPaginationByExpertId) {
            allStatus.add(subject.getStatus());
        }

        Set<Integer> allCategoriesId = new HashSet<>();
        for(Subject subject : subjectsWithPaginationByExpertId) {
            List<Subcategory> subcategories = subject.getSubCategories();
            for(Subcategory subcategory : subcategories) {
                int cId = subcategory.getCategory().getId();
                allCategoriesId.add(cId);
            }
        }

        Set<Category> allCategories = new HashSet<>();
        for(Integer id : allCategoriesId) {
            Category c = iCategoryService.getById(id);
            allCategories.add(c);
        }

        if(searchTerm.isEmpty() && categoryId == -1 && status.equals("-1")) {  // display all subjects (no search, no filter)

            if(!subjectsWithPaginationByExpertId.hasContent()) {
                subjectsWithPaginationByExpertId = iSubjectService.findSubjectsWithPagination(0, itemPerPage);
            }

            model.addAttribute("subjects", subjectsWithPaginationByExpertId);

        } else if(!searchTerm.isEmpty()) {  // perform searching
            subjectsWithPaginationByExpertId = iSubjectService.findSubjectsWithPaginationByExpertIdAndByName(loggedinUser.getId(), searchTerm, pageNum, itemPerPage);
            System.out.println("number of subjects = " + subjectsWithPaginationByExpertId.getTotalElements());

            model.addAttribute("subjects", subjectsWithPaginationByExpertId);
        } else {  //Perform filtering

            Page<Subject> subjectsWithPagination;

            if(!status.equals("-1") && categoryId == -1) {  //filter by status
                Integer statusInt = Boolean.parseBoolean(status) ? 1 : 0;
                subjectsWithPagination = iSubjectService.findSubjectsWithPaginationByExpertIdAndByStatus(loggedinUser.getId(), statusInt, pageNum, itemPerPage);
                model.addAttribute("subjects", subjectsWithPagination);
            }
            if(status.equals("-1") && categoryId != -1) {  //filter by catecory_id
                //Take all subjects + loop through all the subjects and get its list of subcategories
                //loop through received sub-categories and get + get categories from the subcategories list
                subjectsWithPaginationByExpertId = iSubjectService.findSubjectsWithPaginationByExpertId(loggedinUser.getId(), pageNum, itemPerPage);
                HashMap<Integer, Subject> map = new HashMap<>();
                for(Subject subject : subjectsWithPaginationByExpertId) {
                    List<Subcategory> subcategories = subject.getSubCategories();
                    for(Subcategory subcategory : subcategories) {
                        if(Objects.equals(subcategory.getCategory().getId(), categoryId)) {
                            if(!map.containsKey(subject.getId())) {
                                map.put(subject.getId(), subject);
                            }
                        }
                    }
                }

                List<Subject> filteredSubjects = new ArrayList<>(map.values());
                int totalSubjects = filteredSubjects.size();
                subjectsWithPagination = new PageImpl<>(filteredSubjects, PageRequest.of(pageNum, itemPerPage), totalSubjects);

                model.addAttribute("subjects", subjectsWithPagination);
            }
            if (!status.equals("-1") && categoryId != -1) {  //filter by both
                //Take all subjects + loop through all the subjects and get its list of subcategories
                //loop through received sub-categories and get + get categories from the subcategories list
                subjectsWithPaginationByExpertId = iSubjectService.findSubjectsWithPaginationByExpertId(loggedinUser.getId(), pageNum, itemPerPage);
                HashMap<Integer, Subject> map = new HashMap<>();
                for(Subject subject : subjectsWithPaginationByExpertId) {
                    List<Subcategory> subcategories = subject.getSubCategories();
                    for(Subcategory subcategory : subcategories) {
                        if(Objects.equals(subcategory.getCategory().getId(), categoryId)) {
                            if(!map.containsKey(subject.getId())) {
                                map.put(subject.getId(), subject);
                            }
                        }
                    }
                }

                List<Subject> filteredSubjects = new ArrayList<>();
                for(Subject subject : map.values()) {
                    if(subject.getStatus() == Boolean.parseBoolean(status)) {
                        filteredSubjects.add(subject);
                    }
                }
                int totalSubjects = filteredSubjects.size();
                subjectsWithPagination = new PageImpl<>(filteredSubjects, PageRequest.of(pageNum, itemPerPage), totalSubjects);

                model.addAttribute("subjects", subjectsWithPagination);
            }
        }

        model.addAttribute("userSession", session.getAttribute("user"));
        model.addAttribute("subjectName", searchTerm);
        model.addAttribute("pageNum", pageNum);
        model.addAttribute("itemPerPage", itemPerPage);
        model.addAttribute("selectedItemPerPage", itemPerPage);
        model.addAttribute("categories", allCategories);
        model.addAttribute("categoryId", categoryId);
        model.addAttribute("allStatus", allStatus);
        model.addAttribute("selectedStatus", status);

        return "course_content/subjects-list";

    }

    @GetMapping("/admin/new-subject")
    public String getToNewSubjectForm(@ModelAttribute(name = "name") String subjectName,
                                      @ModelAttribute(name = "owner") User owner,
                                      @ModelAttribute(name = "selectedCategory") Category selectedCategory,
                                      @ModelAttribute(name = "selectedSubcategory") Subcategory selectedSubcategory,
                                      @ModelAttribute(name = "selectedFeatured") String selectedFeatured,
                                      @ModelAttribute(name = "selectedStatus") String selectedStatus,
                                      @ModelAttribute(name = "description") String description,
                                      @ModelAttribute(name = "ms1") String ms1,
                                      @ModelAttribute(name = "ms2") String ms2,
                                      Model model, HttpSession session) {

        User loggedinUser = (User)session.getAttribute("user");

        List<Category> allCategories = iCategoryService.listAll();
        List<User> allExperts = iUserService.getAllExpert();
        List<Boolean> isFeatured = new ArrayList<>(Arrays.asList(true, false));
        List<Boolean> status = new ArrayList<>(Arrays.asList(true, false));
        List<Subcategory> allSubcategories = iSubcategoryService.getAll();

        model.addAttribute("userSession", session.getAttribute("user"));
        model.addAttribute("categories", allCategories);
        model.addAttribute("subcategories", allSubcategories);
        model.addAttribute("experts", allExperts);
        model.addAttribute("featured", isFeatured);
        model.addAttribute("status", status);

        if(ms1 != null || ms2 != null) {
            model.addAttribute("name", subjectName);
            model.addAttribute("selectedOwner", owner);
            model.addAttribute("selectedCategory", selectedCategory);
            model.addAttribute("selectedSubcategory", selectedSubcategory);
            model.addAttribute("selectedFeatured", selectedFeatured);
            model.addAttribute("selectedStatus", selectedStatus);
            model.addAttribute("description", description);
            model.addAttribute("ms1", ms1);
            model.addAttribute("ms2", ms2);
        }

        return "course_content/subject_form";
    }

    @PostMapping("/admin/new-subject-submit")
    public String addNewSubject(@RequestParam(name = "name") String subjectName,
                                @RequestParam(name = "category") Integer categoryId,
                                @RequestParam(name = "subcategory") Integer subcategoryId,
                                @RequestParam(name = "owner") Integer ownerId,
                                @RequestParam(name = "featured") Boolean featured,
                                @RequestParam(name = "status") Boolean status,
                                @RequestParam(name = "description") String description,
                                @RequestParam(name = "thumbnail") MultipartFile multipartFile,
                                RedirectAttributes redirectAttribute,
                                Model model, HttpSession session) throws IOException {

        Boolean check = true;
        String ms1 = "", ms2 = "";

        //check if subject name is existed
        if(iSubjectService.checkIfSubjectExistByBriefInfo(subjectName)) {
            check = false;
            ms1 = "Subject Name Existed!";
            System.out.println("condition 1 fail");
        }

        //check if the selected subcategory match the selected category
        Subcategory selectedSubcategory = iSubcategoryService.getById(subcategoryId);
        Category selectedCategory = iCategoryService.getById(categoryId);
        List<Subcategory> selectedCategory_subcategories = selectedCategory.getSubCategories();
        for(Subcategory subcategory : selectedCategory_subcategories) {
            if (!subcategory.getCategory().getName().equals(selectedSubcategory.getCategory().getName())) {
                check = false;
                ms2 = "Selected Subcategory DOES NOT MATCH Selected Category!";
                System.out.println("condition 2 fail");
            } else {
                check = true;
                break;
            }
        }


        System.out.println(check);

        if(check) {  //save new subject

            //Take the file name user has uploaded
            String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
            System.out.println("fileName: " + fileName);
            //Store the fileName into the database with the respective subject

            //Store the actual file to the file directory
            Path fileNameAndPath = Paths.get(FOLDER_PATH, multipartFile.getOriginalFilename());
            String uploadDir = FOLDER_PATH;
            Files.write(fileNameAndPath, multipartFile.getBytes());

            List<Subcategory> subcategories = new ArrayList<>();
            subcategories.add(iSubcategoryService.getById(subcategoryId));

            Subject newSubject = new Subject();
            newSubject.setBriefInfo(subjectName);
            newSubject.setDescription(description);
            newSubject.setFeatured(featured);
            newSubject.setStatus(status);
            newSubject.setOwner(iUserService.getByUserId(ownerId));
            newSubject.setSubCategories(subcategories);
            newSubject.setThumbnail(fileName);

            newSubject = iSubjectRepository.save(newSubject);

            model.addAttribute("check", check);
            return "redirect:../admin/subjects-list?check=" + check;
        } else {  //errors

            System.out.println("ms1: " + ms1);
            System.out.println("ms2: " + ms2);

            redirectAttribute.addFlashAttribute("name", subjectName);
            redirectAttribute.addFlashAttribute("owner", iUserService.getByUserId(ownerId));
            redirectAttribute.addFlashAttribute("selectedCategory", iCategoryService.getById(categoryId));
            redirectAttribute.addFlashAttribute("selectedSubcategory", iSubcategoryService.getById(subcategoryId));
            redirectAttribute.addFlashAttribute("selectedFeatured", featured.toString());
            redirectAttribute.addFlashAttribute("selectedStatus", status.toString());
            redirectAttribute.addFlashAttribute("description", description);
            redirectAttribute.addFlashAttribute("ms1", ms1);
            redirectAttribute.addFlashAttribute("ms2", ms2);
            return "redirect:../admin/new-subject";
        }

    }
}
