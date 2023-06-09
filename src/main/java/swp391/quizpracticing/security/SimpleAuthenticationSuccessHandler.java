package swp391.quizpracticing.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;
import swp391.quizpracticing.model.User;

@Configuration
public class SimpleAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    private HttpSession session;


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        User user=(User)authentication.getPrincipal();
        session=request.getSession();
        session.setAttribute("user", user);
        redirectStrategy.sendRedirect(request, response, "/home");
    }
}