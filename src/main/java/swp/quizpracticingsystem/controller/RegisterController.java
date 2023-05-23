/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp.quizpracticingsystem.controller;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import org.modelmapper.internal.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import swp.quizpracticingsystem.model.User;
import swp.quizpracticingsystem.service.RegisterService;

/**
 *
 * @author Lenovo
 */
@Controller
public class RegisterController {
    
    @Autowired
    private RegisterService service;

    @GetMapping("/register")
    public String register(HttpSession session) {
        if (session.getAttribute("user") != null) {
            return "homepage/homepage";
        } else {
            return "register/register";
        }
    }

    @PostMapping("/register")
    public String processRegister(User user, HttpServletRequest request)
            throws UnsupportedEncodingException, MessagingException {
        service.register(user, getSiteURL(request));       
        return "register_success";
    }
     
    private String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }

    
}
