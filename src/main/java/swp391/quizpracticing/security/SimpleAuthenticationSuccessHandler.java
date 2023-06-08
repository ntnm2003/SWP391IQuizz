package swp391.quizpracticing.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import swp391.quizpracticing.Utility.Utility;
import swp391.quizpracticing.dto.UserDTO;
import swp391.quizpracticing.model.User;
import swp391.quizpracticing.service.IUserService;
import swp391.quizpracticing.serviceimple.UserService;

import java.io.IOException;
import java.util.Collection;

@Configuration
public class SimpleAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    @Autowired
    private ModelMapper modelMapper;
    private UserDTO convertEntityToDTO(User entity){
        return modelMapper.map(entity, UserDTO.class);
    }
    @Autowired
    private IUserService userService;
    @Autowired
    HttpSession session;
    @Autowired
    private UserService us;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        User user = userService.findByEmail(email);
        UserDTO userDTO = convertEntityToDTO(user);
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        authorities.forEach(authority -> {
                session.setAttribute("user", userDTO);
                    throw new IllegalStateException();

            });
        }
    }