/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp.quizpracticingsystem.serviceImple;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import swp.quizpracticingsystem.model.User;
import swp.quizpracticingsystem.repository.RegisterRepository;
import swp.quizpracticingsystem.service.RegisterService;

/**
 *
 * @author Lenovo
 */
@Component
public class RegisterServiceImpl implements RegisterService {


    @Autowired
    RegisterRepository repository;

    @Override
    public boolean verify(String verificationCode) {
        User user = repository.findByVerificationCode(verificationCode);

        if (user == null || user.isEnabled()) {
            return false;
        } else {
            user.setVerificationCode(null);
            user.setEnabled(true);
            repository.save(user);

            return true;
        }
    }

    @Override
    public void register(User user) {
        repository.save(user);
    }

    @Override
    public List<User> getAllAccount() {
        List<User> accountList = repository.findAll();
        return accountList;
    }

}
