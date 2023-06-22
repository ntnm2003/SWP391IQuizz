package swp391.quizpracticing.config;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import swp391.quizpracticing.model.Role;
import swp391.quizpracticing.repository.IRoleRepository;
import swp391.quizpracticing.service.IUserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {

    @Autowired
    private IRoleRepository roleRepository;

    private static final String[] RESOURCE_PATTERN = {"/js/**", "/image/**", "/homepage_assets/**", "/database_images/**", "/css/**", "/templates/**"};

    @Autowired
    private IUserService userService;

    @Bean
    public Map<String, String> patternToRoleMap() {
        Map<String, String> map = new HashMap<>();
        List<Role> roles = roleRepository.findAll();

        for (int i=0; i<roles.size(); i++){
            String pattern = roles.get(i).getUrlPattern();
            String role=roles.get(i).getName();
            map.put(pattern, role);
            System.out.println(pattern);
        }
        return map;
    }
    private final Map<String, String> patternToRoleMap; // Map to hold list pattern to role mapping

    public WebSecurityConfig(Map<String, String> patternToRoleMap) {
        this.patternToRoleMap = patternToRoleMap;
    }

    @Bean
    public SecurityFilterChain security(HttpSecurity http) throws Exception{
//       return http.csrf().disable().authorizeHttpRequests(authorize -> {
//            patternToRoleMap.forEach((pattern, role) -> authorize.requestMatchers(pattern).hasRole(role.substring(5)));
//        }).authorizeHttpRequests().anyRequest().authenticated().and().
//        formLogin().loginPage("/login")
//               .successHandler(new SimpleAuthenticationSuccessHandler())
//                .failureHandler(new SimpleAuthenticationFailureHandler())
//                .usernameParameter("email")
//                .passwordParameter("password").permitAll()
//                .and()
//                .exceptionHandling().accessDeniedHandler(accessDeniedHandler())
//                .and().build();

        return http.csrf().disable()
                .authorizeHttpRequests()
//                .requestMatchers(roleRepository.findAll().stream().map(Role::getUrlPattern).toList().toArray(new String[0]))
//                .access((authentication, e) -> {
//                    HttpServletRequest request = e.getRequest();
//                    List<String> roles = roleRepository.findRolesByUrlPattern(request.getServletPath()).stream().map(Role::getName).toList();
//                    return new AuthorizationDecision(authentication.get().getAuthorities().stream().anyMatch(grantedAuthority
//                            -> roles.contains(grantedAuthority.getAuthority())));
//                })

                .requestMatchers(RESOURCE_PATTERN).permitAll()
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/user/**").hasRole("CUSTOMER")
                .requestMatchers("/marketing/**").hasRole("MARKETING")
                .requestMatchers("/sale/**").hasRole("SALE")
                .requestMatchers("/expert/**").hasRole("EXPERT")
                .requestMatchers("/lesson/**").permitAll()
                .and()
                .authorizeHttpRequests()
                .anyRequest().permitAll()
                .and().formLogin().loginPage("/login")
                .successHandler(new SimpleAuthenticationSuccessHandler())
                .failureHandler(new SimpleAuthenticationFailureHandler())
                .usernameParameter("email")
                .passwordParameter("password").permitAll()
                .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler())
                .and().build();
    }
    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public AuthenticationProvider authentication(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }
    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
            .authenticationProvider(authentication())
            .build();
    }
}
