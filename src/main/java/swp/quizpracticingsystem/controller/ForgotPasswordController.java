/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp.quizpracticingsystem.controller;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.modelmapper.internal.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import swp.quizpracticingsystem.Utility.Utility;
import swp.quizpracticingsystem.model.User;
import swp.quizpracticingsystem.serviceImple.AccountService;

/**
 *
 * @author Admin
 */
@Controller
public class ForgotPasswordController {
    @Autowired
    private JavaMailSender javaMailSender;
    
    @Autowired
    private AccountService accountService;
    
    @GetMapping("/forgot_password")
    public String showForgotPasswordForm(){
        return "password/forgot_password_form";
    }
    
    @PostMapping("/forgot_password")
    public String processForgotPassword(HttpServletRequest request,Model model) {
        String email = request.getParameter("email");
        String token = RandomString.make(30);
        try {
            accountService.updateResetPasswordToken(token, email);
            String resetPasswordLink = Utility.getSiteURL(request) + "/reset_password?token=" + token;
            sendEmail(email, resetPasswordLink);
            model.addAttribute("message", "Email has been sent, Please check your inbox !");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return "password/forgot_password_form";
    }
    
    public void sendEmail(String recipientEmail, String link)
            throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom("gmail@sss", "Iquiz");
        helper.setTo(recipientEmail);

        String subject = "Here's the link to reset your password";

        String content = "<p>Hello,</p>"
                + "<p>You have requested to reset your password.</p>"
                + "<p>Click the link below to change your password:</p>"
                + "<p><a href=\"" + link + "\">Change my password</a></p>"
                + "<br>"
                + "<p>Ignore this email if you do remember your password, "
                + "or you have not made the request.</p>";

        helper.setSubject(subject);

        helper.setText(content, true);

        javaMailSender.send(message);
    }
    
    @GetMapping("/reset_password")
    public String showResetPasswordForm(@Param(value = "token") String token) {

        User account = accountService.getByResetPasswordToken(token);
        String pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime dateTime = LocalDateTime.parse(account.getLastupdatedatetime(), formatter);

        LocalDateTime currentDateTime = LocalDateTime.now();

        if (currentDateTime.compareTo(dateTime) > 0) {
            return "timeout";
        } else {
            return "password/reset_password_form";
        }
    }
    
    @PostMapping("/reset_password")
    public String processResetPassword(HttpServletRequest request, User a,Model model) {
         String newPass = request.getParameter("newPass");
        String confirmPass = request.getParameter("confirmPass");
        if(newPass.matches(confirmPass)){
        User acc = accountService.getByResetPasswordToken(a.getToken());
        acc.setPassword(newPass);
        accountService.updatePassword(acc, newPass);
        return "login/login";
        }else{
             model.addAttribute("error", "Incorrect Re-enter new password");
             return"password/reset_password_form";
                }
    }
}
