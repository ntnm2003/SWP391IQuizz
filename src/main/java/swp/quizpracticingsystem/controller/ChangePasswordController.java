/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp.quizpracticingsystem.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    public String showChangePasswordForm(){
        return "password/change_password_form";
    }
    
    @PostMapping("/change_password")
    public String processChangePassword(HttpServletRequest request, Model model){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        
        String oldPassword = request.getParameter("oldPass");
        String newPassword = request.getParameter("newPass");
        String confirmPassword = request.getParameter("confirmPass");
        HttpSession session = request.getSession(false);
        
        if (session != null && session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            if (passwordEncoder.matches(oldPassword, user.getPassword())) {
                if(newPassword.matches(confirmPassword)){
                user.setPassword(passwordEncoder.encode(newPassword));
                accountService.updatePassword(user, newPassword);
                return "redirect:/home";
                }else{
                    model.addAttribute("error2","Wrong re-enter new password");
                    return "password/change_password_form";
                }
            } else {
                model.addAttribute("error1", "Wrong old password");
                return "password/change_password_form";
            }
        } else {
            return "redirect:/login";
        }
            
    }
}
