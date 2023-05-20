package swp.quizpracticingsystem.dto;

import java.sql.Date;
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
    private String thumbnail;
    private Integer postCategoryId;
    private String title;
    private Date updatedDate;
    private String author;
    private String briefInfor;
    private String description;
    private String status;
    private Boolean featuring;
}
