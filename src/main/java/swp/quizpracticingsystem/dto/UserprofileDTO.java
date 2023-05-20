package swp.quizpracticingsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserprofileDTO {
    private Integer userProfileId;
    private Integer userId;
    private String avatar;
    private String headline;
}
