package swp391.quizpracticing.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SliderDTO {
    private Integer id;
    private String title;
    private String image;
    private String backLink;
    private Boolean status;
}
