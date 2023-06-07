/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp391.quizpracticing.serviceImple;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import swp391.quizpracticing.model.Role;
import swp391.quizpracticing.model.User;
import swp391.quizpracticing.repository.RegisterRepository;
import swp391.quizpracticing.service.RegisterService;

/**
 *
 * @author Lenovo
 */
@Service
public class RegisterServiceImpl implements RegisterService {


    @Autowired
    RegisterRepository repository;

    @Override
    public boolean verify(String verificationCode) {
        User user = repository.findByToken(verificationCode);

        if (user == null || user.getEnable()) {
            return false;
        } else {
            user.setToken(null);
            user.setEnable(true);
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