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
import swp391.quizpracticing.dto.RoleDTO;
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
            @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
            @RequestParam(name = "filteredGender", 
                    required = false) Boolean gender,
            @RequestParam(name = "filteredStatus", 
                    required = false) Boolean status,
            @RequestParam(name ="filteredRole",
                    required=false) Integer roleId,
            @RequestParam(name = "sortBy", defaultValue = "id") String sortBy,
            @RequestParam(name = "order",defaultValue = "asc") String order){
        int pageSize=6;
        List<UserDTO> users;
        users=userService.getUsers(pageNo, pageSize, gender,
                status, roleId, sortBy, order);
        model.addAttribute("users", users);
        return "admin/admin";
    }
    
    @GetMapping("/admin/search-user")
    public String searchUser(Session session,
            Model model,
            @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
            @RequestParam(name="search", required = false) String searchBy,
            @RequestParam(name="searchValue", required = false) String searchValue,
            @RequestParam(name = "filteredGender", 
                    required = false) Boolean gender,
            @RequestParam(name = "filteredStatus", 
                    required = false) Boolean status,
            @RequestParam(name ="filteredRole",
                    required=false) Integer roleId,
            @RequestParam(name = "sortBy", defaultValue = "id") String sortBy,
            @RequestParam(name = "order",defaultValue = "asc") String order){
        int pageSize=6;
        List<UserDTO> users;
        users=userService.searchUserBy(pageNo, pageSize, searchBy, 
                searchValue, gender, status, roleId, sortBy, order);
        model.addAttribute("users", users);
        return "admin/admin";
    }
    
    @GetMapping("/admin/settings")
    public String getSettingsPage(){
        return "admin/settings";
    }
}
