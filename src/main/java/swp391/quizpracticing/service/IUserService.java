/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package swp391.quizpracticing.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.data.domain.Page;
import swp391.quizpracticing.dto.UserDTO;
import swp391.quizpracticing.model.Role;
import swp391.quizpracticing.model.User;

/**
 *
 * @author Mosena
 */
public interface IUserService extends UserDetailsService {
    User findByEmail(String email);
    int countUsersByRolesLike(String role);
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    public Page<UserDTO> searchUserBy(int pageNo, int pageSize,
            String searchValue, Boolean gender, Boolean status, Integer roleId, 
            String sortBy, String order);
    public UserDTO addUser(String fullName,String email, String password);
    public void updateUser(Integer userId,Integer roleId, Boolean status);
    public Page<UserDTO> getUsers(int pageNo, int pageSize,
                                  Boolean gender, Boolean status, Integer roleId,
                                  String sortBy, String order);
}
