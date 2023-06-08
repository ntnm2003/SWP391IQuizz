/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package swp391.quizpracticing.service;

import org.springframework.data.domain.Page;
import swp391.quizpracticing.dto.UserDTO;

/**
 *
 * @author Mosena
 */
public interface IUserService {
    public Page<UserDTO> getUsers(int pageNo, int pageSize,
            String searchValue, Boolean gender, Boolean status, Integer roleId, 
            String sortBy, String order);
    public void addUser(UserDTO u);
    public void updateUser(Integer userId,Integer roleId, Boolean status);
    public UserDTO findUser(Integer id);
    public UserDTO findUserByToken(String token);
    public void updateUserStatusAndToken(Integer userId, Boolean status);
    public void remove(UserDTO u);
    public boolean findUserByEmail(String email);
}
