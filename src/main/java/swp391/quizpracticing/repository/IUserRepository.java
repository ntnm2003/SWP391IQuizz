/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package swp391.quizpracticing.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import swp391.quizpracticing.model.User;

/**
 *
 * @author Mosena
 */
@Repository
public interface IUserRepository  extends JpaRepository<User,Integer> {
    @Override
    public Page<User> findAll(Pageable pageable);
    
    @Override
    public User getById(Integer id);
//    
//    @Query(value="select * from User where name like %?1%")
//    public Page<User>searchByName(Pageable pageable,String name);
//    
//    @Query(value="select * from User where email like %?1%")
//    public Page<User>searchByEmail(Pageable pageable, String email);
}
