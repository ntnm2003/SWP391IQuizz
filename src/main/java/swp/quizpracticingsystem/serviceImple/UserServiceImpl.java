/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp.quizpracticingsystem.serviceImple;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import swp.quizpracticingsystem.model.User;
import swp.quizpracticingsystem.repository.UserRepository;
import swp.quizpracticingsystem.service.UserService;

/**
 *
 * @author Lenovo
 */
@Component
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    @Override
    public User login(String email, String password) {
        Optional<User> acc = userRepository.findUserByEmailAndPassword(email,
                password);
        return acc.isPresent() ? acc.get() : null;
    }
    
}
