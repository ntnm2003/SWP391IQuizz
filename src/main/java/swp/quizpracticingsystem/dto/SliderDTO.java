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
    private Integer userId;
    private String title;
    private byte[] image;
    private String backlink;
    private String status;
    private boolean visibility;
    private Integer sliderCategoryId;
}
