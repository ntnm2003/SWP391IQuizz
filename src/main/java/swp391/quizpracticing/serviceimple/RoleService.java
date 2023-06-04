/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp391.quizpracticing.serviceimple;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swp391.quizpracticing.dto.RoleDTO;
import swp391.quizpracticing.model.Role;
import swp391.quizpracticing.service.IRoleService;

/**
 *
 * @author Mosena
 */
@Service
public class RoleService implements IRoleService {
    @Autowired
    private ModelMapper modelMapper;
    
    private RoleDTO convertEntityToDTO(Role entity){
        return modelMapper.map(entity,RoleDTO.class);
    }
}
