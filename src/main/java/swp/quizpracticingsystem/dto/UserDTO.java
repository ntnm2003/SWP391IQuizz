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
    private String full;
    private String email;
    private boolean gender;
    private Integer mobile;
    private String password;
    private Integer roleId;
    private Integer courseId;
}
