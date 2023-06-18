/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp391.quizpracticing.controller;

import jakarta.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import swp391.quizpracticing.dto.RegistrationstatusDTO;
import swp391.quizpracticing.dto.UserSubjectDTO;
import swp391.quizpracticing.service.IUserSubjectService;

/**
 *
 * @author Mosena
 */
@Controller
@RequestMapping("/sale")
public class SaleController {
    
    @Autowired
    private IUserSubjectService userSubjectService;
    
    @GetMapping("/registrations-list")
    public String getRegistrations(HttpSession session, 
            @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
            @RequestParam(name = "sortBy", defaultValue = "id") String sortBy, 
            @RequestParam(name = "order", defaultValue = "asc") String order, 
            @RequestParam(name = "searchValue", required = false) String search, 
            @RequestParam(name = "validFrom", required = false) Timestamp validFrom, 
            @RequestParam(name = "validTo", required = false) Timestamp validTo,
            @RequestParam(name = "status", required = false) String status, 
            Model model){
        int pageSize=6;
        Page<UserSubjectDTO> registrations=userSubjectService.listAll(pageNo, 
                pageSize, sortBy, order, search, 
                validFrom, validTo, status);
        int totalPages=registrations.getTotalPages();
        if(totalPages==0 || pageNo<1 || pageNo>totalPages){
            model.addAttribute("msg", "Not found");
            return "/admin/error";
        }
        List<String> statusList=userSubjectService
                .getRegistrationStatusList(registrations);
        List<Timestamp> validFromList=userSubjectService
                .getValidFromList(registrations);
        List<Timestamp> validToList=userSubjectService
                .getValidToList(registrations);
        model.addAttribute("userSession", 
                session.getAttribute("user"));
        model.addAttribute("statusList", statusList);
        model.addAttribute("validFromList", validFromList);
        model.addAttribute("validToList", validToList);
        model.addAttribute("registrations", registrations);
        model.addAttribute("pageNo", pageNo);
        model.addAttribute("totalPages",totalPages);
        return "/sale/registrations";
    }
}
