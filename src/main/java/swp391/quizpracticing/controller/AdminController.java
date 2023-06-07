/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp391.quizpracticing.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties.Reactive.Session;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import swp391.quizpracticing.dto.RoleDTO;
import swp391.quizpracticing.dto.SettingsDTO;
import swp391.quizpracticing.dto.UserDTO;
import swp391.quizpracticing.service.IRoleService;
import swp391.quizpracticing.service.ISettingsService;
import swp391.quizpracticing.service.IUserService;

/**
 *
 * @author Mosena
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    
    @Autowired
    private IUserService userService;
    
    @Autowired
    private ISettingsService settingsService;
    
    @Autowired
    private IRoleService roleService;
    
    @GetMapping("/user-list")
    public String getUserListPage(Session session,
            Model model,
            @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
            @RequestParam(name = "gender", 
                    required = false) Boolean gender,
            @RequestParam(name = "status", 
                    required = false) Boolean status,
            @RequestParam(name ="role",
                    required=false) Integer roleId,
            @RequestParam(name = "sortBy", defaultValue = "id") String sortBy,
            @RequestParam(name = "order",defaultValue = "asc") String order){
        int pageSize=6;
        Page<UserDTO> users=userService.getUsers(pageNo, pageSize, gender,
                status, roleId, sortBy, order);
        List<RoleDTO> roles=roleService.findRoles();
        model.addAttribute("roles", roles);
        model.addAttribute("pageNo",pageNo);
        model.addAttribute("totalPages", 
                users.getTotalPages());
        model.addAttribute("users", users);
        model.addAttribute("session", session);
        return "admin/userlist";
    }
    
    @GetMapping("/search-user")
    public String searchUser(Session session,
            Model model,
            @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
            @RequestParam(name="searchValue", required = false) String searchValue,
            @RequestParam(name = "gender", 
                    required = false) Boolean gender,
            @RequestParam(name = "status", 
                    required = false) Boolean status,
            @RequestParam(name ="role",
                    required=false) Integer roleId,
            @RequestParam(name = "sortBy", defaultValue = "id") String sortBy,
            @RequestParam(name = "order",defaultValue = "asc") String order){
        int pageSize=6;
        Page<UserDTO> users;
        if(searchValue==null){
            users=userService.getUsers(pageNo, pageSize, 
                    gender, status, roleId, sortBy, order);
        }
        else{
            users=userService.searchUserBy(pageNo, pageSize, 
                searchValue, gender, status, roleId, sortBy, order);
        }
        List<RoleDTO> roles=roleService.findRoles();
        model.addAttribute("roles", roles);
        model.addAttribute("pageNo",pageNo);
        model.addAttribute("totalPages", 
                users.getTotalPages());
        model.addAttribute("users", users);
        model.addAttribute("session", session);
        return "admin/userlistsearch";
    }
    
    @GetMapping("/settings")
    public String getSettingsPage(Session session,
            Model model,
            @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
            @RequestParam(name="type", required = false) String type,
            @RequestParam(name="status",required = false) Boolean status,
            @RequestParam(name = "sortBy", defaultValue = "id") String sortBy,
            @RequestParam(name = "order",defaultValue = "asc") String order){
        int pageSize=6;
        Page<SettingsDTO>settings=settingsService.getSettings(pageNo, pageSize, 
                type, status, sortBy, order);
        List<String> types=settingsService.findTypes();
        model.addAttribute("types", types);
        model.addAttribute("pageNo",pageNo);
        model.addAttribute("totalPages", 
                settings.getTotalPages());
        model.addAttribute("settings", settings);
        model.addAttribute("session", session);
        return "admin/settings";
    }
    
    @GetMapping("/search-setting")
    public String searchSetting(Session session,
            Model model,
            @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
            @RequestParam(name="value", required = false) String value,
            @RequestParam(name="type", required = false) String type,
            @RequestParam(name="status",required = false) Boolean status,
            @RequestParam(name = "sortBy", defaultValue = "id") String sortBy,
            @RequestParam(name = "order",defaultValue = "asc") String order){
        int pageSize=6;
        Page<SettingsDTO>settings;
        if(value==null){
            settings=settingsService.getSettings(pageNo, pageSize, type, 
                    status, sortBy, order);
        }
        else{
            settings=settingsService.searchSettings(pageNo, pageSize,
                    type, status, sortBy, order, value);
        }
        List<String> types=settingsService.findTypes();
        model.addAttribute("types", types);
        model.addAttribute("pageNo",pageNo);
        model.addAttribute("totalPages", 
                settings.getTotalPages());
        model.addAttribute("settings", settings);
        model.addAttribute("session", session);
        return "admin/settingssearch";
    }
}
