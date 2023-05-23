/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp.quizpracticingsystem.service;


import org.springframework.stereotype.Service;
import swp.quizpracticingsystem.model.User;

/**
 *
 * @author Lenovo
 */
@Service
public interface RegisterService {

    void register(User user, String siteURL) {
        
    }

    void sendVerificationEmail(User user, String siteURL) {

    }


}
