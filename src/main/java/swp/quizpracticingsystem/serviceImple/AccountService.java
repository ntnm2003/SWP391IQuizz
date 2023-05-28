/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp.quizpracticingsystem.serviceImple;

import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import swp.quizpracticingsystem.model.User;
import swp.quizpracticingsystem.repository.IAccountRepository;
import swp.quizpracticingsystem.service.IAccountService;

/**
 *
 * @author Admin
 */
@Service
@Transactional
public class AccountService implements IAccountService{
    
    @Autowired
    IAccountRepository accountRepository;
    
    @Value("${reset.link.timeout}")
    private int timeout;

    @Override
    public void updateResetPasswordToken(String token, String email) {
        User acc = accountRepository.findByEmail(email);
        if (acc != null) {
            acc.token(token);
            LocalDateTime currentDateTime = LocalDateTime.now();
            LocalDateTime updatedDateTime = currentDateTime.plusMinutes(timeout);
            acc.setLastupdatedatetime(updatedDateTime.toString());
            accountRepository.save(acc);
        }
    }

    @Override
    public User getByResetPasswordToken(String token) {
        return accountRepository.findAccountByToken(token);
    }

    @Override
    public void updatePassword(User acc, String newPassword) {
        acc.setPassword(newPassword);

        acc.token(null);
        accountRepository.save(acc);
    }
    
}
