/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package swp391.quizpracticing.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import swp391.quizpracticing.model.Role;
import swp391.quizpracticing.model.User;

/**
 *
 * @author Mosena
 */
@Repository
public interface IUserRepository  extends JpaRepository<User,Integer>
        , JpaSpecificationExecutor<User> {
    
    @Override
    public Page<User> findAll(Specification spec,Pageable pageable);
    
    @Override
    public Page<User>findAll(Pageable pageable);

    @Override
    public User save(User u);
    
    @Modifying
    @Query("UPDATE User u SET u.enable = :status WHERE u.id = :userId")
    void updateUserStatus(@Param("userId") Integer userId, 
            @Param("status") Boolean status);
    
    @Modifying
    @Query("UPDATE User u SET u.role = :role WHERE id = :userId")
    void updateUserRole(@Param("userId") Integer userId, 
            @Param("role") Role role);
}
