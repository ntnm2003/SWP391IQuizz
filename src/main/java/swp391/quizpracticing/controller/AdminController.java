/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp391.quizpracticing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties.Reactive.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import swp391.quizpracticing.service.IUserService;

/**
 *
 * @author Mosena
 */
@Controller
public class AdminController {
    
    @Autowired
    private IUserService userService;
    
    @GetMapping("/admin")
    public String getAdminPage(Session session){
        return "admin/admin";
    }
    
    @GetMapping("/admin/settings")
    public String getSettingsPage(){
        return "admin/settings";
    }
}
