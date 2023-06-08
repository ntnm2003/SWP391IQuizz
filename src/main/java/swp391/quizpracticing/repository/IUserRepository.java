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

import java.util.Optional;

/**
 *
 * @author Mosena
 */
@Repository
public interface IUserRepository extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {

    @Override
    public Page<User> findAll(Specification spec,Pageable pageable);

    @Override
    public Page<User> findAll(Pageable pageable);

    @Override
    public User save(User u);

    @Override
    public User getById(Integer id);

    public User findById(int id);

    @Modifying
    @Query("UPDATE User u SET u.enable = :status WHERE u.id = :userId")
    public void updateUserStatus(@Param("userId") Integer userId,
            @Param("status") Boolean status);
    
    @Modifying
    @Query("UPDATE User u SET u.role = :role WHERE u.id = :userId")
    public void updateUserRole(@Param("userId") Integer userId,
            @Param("role") Role role);

    User findByEmail(String email);
    @Query(value = "select count(*) from user_roles where role_id in (select id from roles where `name` = ?1)", nativeQuery = true)
    int countUsersByRolesLike(String role);


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
