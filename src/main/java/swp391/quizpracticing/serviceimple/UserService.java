/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp391.quizpracticing.serviceimple;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swp391.quizpracticing.dto.UserDTO;
import swp391.quizpracticing.model.User;
import swp391.quizpracticing.service.IUserService;

/**
 *
 * @author Mosena
 */
@Service
public class UserService implements IUserService {
    @Autowired
    private ModelMapper modelMapper;
    
    private UserDTO convertEntityToDTO(User entity){
        return modelMapper.map(entity,UserDTO.class);
    }
}
