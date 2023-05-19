package swp.quizpracticingsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostsDTO {
    private Integer postId;
    private Integer userId;
    private byte []thumbnail;
    private Integer postCategoryId;
    private String title;
    private String briefInfor;
    private String description;
    private String status;
    private boolean featuring;
}
