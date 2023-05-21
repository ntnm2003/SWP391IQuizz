package swp.quizpracticingsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Integer userId;
    private String fullName;
    private String email;
    private Boolean gender;
    private String mobile;
    private String password;
    private RoleDTO role;
}
