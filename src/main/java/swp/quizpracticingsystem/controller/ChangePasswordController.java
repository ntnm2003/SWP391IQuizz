/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp.quizpracticingsystem.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import swp.quizpracticingsystem.model.User;
import swp.quizpracticingsystem.repository.IAccountRepository;
import swp.quizpracticingsystem.service.IAccountService;
import swp.quizpracticingsystem.serviceImple.AccountService;

/**
 *
 * @author Admin
 */
@Controller
public class ChangePasswordController {
    
    @Autowired
    private IAccountService iAccountService;
    
    @Autowired
    private AccountService accountService;
    
    @Autowired
    private IAccountRepository iAccountRepository;
    
    @GetMapping("/change_password")
    public String showChangePasswordForm(HttpServletRequest request,Model model){
        HttpSession session = request.getSession(false);
        if(session != null && session.getAttribute("user") != null){
            return"password/change_password_form";
        }else{
            return"login/login";
        }
    }
    
    @PostMapping("/change_password")
    public String processChangePassword(HttpServletRequest request,User user,Model model){
            HttpSession session = request.getSession(false);
            String oldPass = request.getParameter("oldPass");
            String newPass = request.getParameter("newPass");
            String confirmPass = request.getParameter("confirmPass");
            user = (User) session.getAttribute("user");
            if(oldPass.matches(user.getPassword())){
                if(newPass.matches(confirmPass)){
                    user.setPassword(newPass);
                    accountService.updatePassword(user, newPass);
                    return "redirect:/login";
                }else{
                    model.addAttribute("error2", "Incorrect Re-enter New Password");
                    return "password/change_password_form";
                }
            }else{
                model.addAttribute("error1", "Incorrect Old Password");
                return "password/change_password_form";
            }
    }
}
