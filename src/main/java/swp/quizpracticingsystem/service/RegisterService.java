/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp.quizpracticingsystem.service;


import java.util.List;
import org.springframework.stereotype.Service;
import swp.quizpracticingsystem.model.User;

/**
 *
 * @author Lenovo
 */
public interface RegisterService {

    public void register(User user);
    boolean verify(String verificationCode);

    public List<User> getAllAccount();
    


}
