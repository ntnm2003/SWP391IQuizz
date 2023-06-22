/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp391.quizpracticing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import swp391.quizpracticing.dto.UserDTO;
import swp391.quizpracticing.service.IUserService;

/**
 *
 * @author Mosena
 */
@Controller
public class PublicController {
    @Autowired
    private IUserService userService;
    
    @GetMapping("/user-created/verify")
    public String verify(@RequestParam("code") String code, Model model){
        UserDTO u=userService.findUserByToken(code);
        if(u!=null){
            userService.updateUserStatusAndToken(u.getId(), Boolean.TRUE);
            return "/common/verify_success";
        }
        model.addAttribute("msg", "Get lost?");
        return "/admin/error";
    }
    @GetMapping("/user-created/discard")
    public String discard(@RequestParam("code") String code, Model model){
        UserDTO u=userService.findUserByToken(code);
        if(u!=null){
            userService.remove(u);
            return "/admin/discardaccount";
        }
        model.addAttribute("msg", "Get lost?");
        return "/admin/error";
    }
}
