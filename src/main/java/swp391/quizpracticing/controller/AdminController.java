/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp391.quizpracticing.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties.Reactive.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import swp391.quizpracticing.dto.UserDTO;
import swp391.quizpracticing.service.IUserService;

/**
 *
 * @author Mosena
 */
@Controller
public class AdminController {
    
    @Autowired
    private IUserService userService;
    
    @GetMapping("/admin/user-list")
    public String getUserListPage(Session session,
            Model model,
            @RequestParam(name = "pageNo", defaultValue = "1") int pageNo){
        int pageSize=6;
        List<UserDTO> users=userService.getUsers(pageNo-1, pageSize);
        model.addAttribute("users", users);
        return "admin/admin";
    }
    
    @GetMapping("/admin/settings")
    public String getSettingsPage(){
        return "admin/settings";
    }
}
