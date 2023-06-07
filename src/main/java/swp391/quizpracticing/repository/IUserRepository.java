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

import java.util.Optional;

/**
 *
 * @author Mosena
 */
@Repository
public interface IUserRepository extends JpaRepository<User,Integer> {
    @Override
    public Page<User> findAll(Pageable pageable);
    
    @Override
    public User getById(Integer id);

    public User findById(int id);
    
    @Query(value="select * from User where full_name like %?1%", 
            nativeQuery = true)
    public Page<User>searchByName(Pageable pageable,String fullName);
    
    @Query(value="select * from User where email like %?1%", 
            nativeQuery = true)
    public Page<User>searchByEmail(Pageable pageable, String email);
    
    @Query(value="select * from User where mobile like %?1%",
            nativeQuery = true)
    public Page<User>searchByPhoneNumber(Pageable pageable, String phone);
}
