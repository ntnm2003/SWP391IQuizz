package swp.quizpracticingsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SliderDTO {
    private Integer sliderId;
    private UserDTO user;
    private String title;
    private String image;
    private String backlink;
    private String status;
    private Boolean visibility;
}
