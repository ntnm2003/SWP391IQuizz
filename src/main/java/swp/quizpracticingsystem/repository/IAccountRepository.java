/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp.quizpracticingsystem.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import swp.quizpracticingsystem.model.User;

/**
 *
 * @author Admin
 */
@Repository
public interface IAccountRepository extends JpaRepository<User, Integer>{
    
    Optional<User> findAccountByEmailAndPassword(String username, String password);

    User findByEmail(String email);

    User findAccountByToken(String token);
    
}
