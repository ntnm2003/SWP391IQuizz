/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp.quizpracticingsystem.service;

import org.springframework.stereotype.Service;
import swp.quizpracticingsystem.model.User;

/**
 *
 * @author Admin
 */
public interface IAccountService {
    
    void updateResetPasswordToken(String token, String email);

    User getByResetPasswordToken(String token);

    void updatePassword(User acc, String password);
    
}
