
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp391.quizpracticing.controller;

import jakarta.servlet.http.HttpSession;
import java.util.List;
import org.modelmapper.internal.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import swp391.quizpracticing.dto.RoleDTO;
import swp391.quizpracticing.dto.SettingsDTO;
import swp391.quizpracticing.dto.UserDTO;
import swp391.quizpracticing.service.IRoleService;
import swp391.quizpracticing.service.ISettingsService;
import swp391.quizpracticing.service.IUserService;
import swp391.quizpracticing.service.IVerificationService;
import swp391.quizpracticing.service.RegisterService;

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
    
    @Autowired
    private RegisterService registerService;
    
    @Autowired
    private IVerificationService verifycationService;
    
    @GetMapping("/user-list")
    public String searchUser(HttpSession session,
            Model model,
            @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
            @RequestParam(name="searchValue", required = false) String searchValue,
            @RequestParam(name = "gender", 
                    required = false) Boolean gender,
            @RequestParam(name = "enable", 
                    required = false) Boolean status,
            @RequestParam(name ="role",
                    required=false) Integer roleId,
            @RequestParam(name = "sortBy", defaultValue = "id") String sortBy,
            @RequestParam(name = "order",defaultValue = "asc") String order){
        int pageSize=6;
        Page<UserDTO> users=userService.getUsers(pageNo, pageSize, 
                searchValue, gender, status, roleId, sortBy, order);
        List<RoleDTO> roles=roleService.findRoles();
        int totalPages=users.getTotalPages();
        if(totalPages==0 || pageNo<1 || pageNo>totalPages){
            model.addAttribute("msg", "Not found");
            return "/admin/error";
        }
        model.addAttribute("userSession", session.getAttribute("user"));
        model.addAttribute("roles", roles);
        model.addAttribute("pageNo",pageNo);
        model.addAttribute("totalPages",totalPages);
        model.addAttribute("users", users);
        return "/admin/userlist";
    }
    
    @GetMapping("/settings")
    public String searchSetting(HttpSession session,
            Model model,
            @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
            @RequestParam(name="value", required = false) String value,
            @RequestParam(name="type", required = false) String type,
            @RequestParam(name="enable",required = false) Boolean status,
            @RequestParam(name = "sortBy", defaultValue = "id") String sortBy,
            @RequestParam(name = "order",defaultValue = "asc") String order){
        int pageSize=6;
        Page<SettingsDTO>settings=settingsService
                .getSettings(pageNo, pageSize,type, status,
                        sortBy, order, value);
        List<String> types=settingsService.findTypes();
        int totalPages=settings.getTotalPages();
        if(totalPages==0 || pageNo<1 || pageNo>totalPages){
            model.addAttribute("msg", "Not found");
            return "/admin/error";
        }
        model.addAttribute("userSession", session.getAttribute("user"));
        model.addAttribute("types", types);
        model.addAttribute("pageNo",pageNo);
        model.addAttribute("totalPages",totalPages);
        model.addAttribute("settings", settings);
        return "/admin/settings";
    }
    
    @GetMapping("/user-detail")
    public String getUser(HttpSession session, @RequestParam("userId") Integer userId, Model model){
        UserDTO u=userService.findUser(userId);
        List<RoleDTO> roles=roleService.findRoles();
        model.addAttribute("userSession", session.getAttribute("user"));
        model.addAttribute("roles", roles);
        model.addAttribute("user", u);
        return "/admin/userdetail";
    }
    @GetMapping("/setting-detail")
    public String getSetting(HttpSession session,@RequestParam("settingId") Integer settingId, Model model){
        SettingsDTO s=settingsService.findById(settingId);
        List<String> types=settingsService.findTypes();
        model.addAttribute("userSession", session.getAttribute("user"));
        model.addAttribute("types", types);
        model.addAttribute("setting",s);
        return "/admin/settingdetail";
    }
    @PostMapping("/user-detail/change")
    public String updateUser(HttpSession session,@RequestParam("id") Integer id, 
            @RequestParam("role") Integer roleId,
            @RequestParam("enable") Boolean status,
            Model model){
        model.addAttribute("userSession", session.getAttribute("user"));
        userService.updateUser(id, roleId, status);
        return "redirect:/admin/user-detail?userId="+id;
    }
    
    @PostMapping("/add-user")
    public String addUser(HttpSession session,@RequestParam("fullName") String fullName,
            @RequestParam("role") Integer roleId,
            @RequestParam("email") String email,
            Model model){
        if(userService.findUserByEmail(email)){
            model.addAttribute("msg", 
                    "Email has already existed");
            return "/admin/error";
        }
        UserDTO u=new UserDTO();
        String randomCode = RandomString.make(64);
        String randomPass=RandomString.make(12);
        RoleDTO r=roleService.findRole(roleId);
        model.addAttribute("userSession", session.getAttribute("user"));
        u.setToken(randomCode);
        u.setRole(r);
        u.setFullName(fullName);
        u.setEmail(email);
        u.setPassword(randomPass);
        u.setEnable(false);
        registerService.register(u);
        verifycationService.sendVerification(fullName, email, 
                randomCode,randomPass);
        return "redirect:/admin/user-list";
    }
    @PostMapping("/setting-detail/change")
    public String updateSetting(HttpSession session, Model model,@RequestParam("id") Integer id, 
            @RequestParam("value") String value,
            @RequestParam("order") Integer order,
            @RequestParam("description") String description,
            @RequestParam("status") Boolean status){
        model.addAttribute("userSession", session.getAttribute("user"));
        settingsService.updateSettings(id, value, order, status, description);
        return "redirect:/admin/setting-detail?settingId="+id;
    }
    
    @PostMapping("/add-setting")
    public String addSetting(
            HttpSession session,
            Model model,
            @RequestParam("type") String type,
            @RequestParam("value") String value,
            @RequestParam("order") Integer order,
            @RequestParam("description") String description){
        model.addAttribute("userSession", session.getAttribute("user"));
        settingsService.addSetting(type, order, value, description);
        return "redirect:/admin/settings";
    }
}

