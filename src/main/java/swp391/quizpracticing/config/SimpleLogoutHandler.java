/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp391.quizpracticing.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.logout.LogoutHandler;

/**
 *
 * @author Mosena
 */
public class SimpleLogoutHandler implements LogoutHandler {
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication){
        try {
            redirectStrategy.sendRedirect(request, response, "/home");
        } catch (IOException ex) {
            Logger.getLogger(SimpleLogoutHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
