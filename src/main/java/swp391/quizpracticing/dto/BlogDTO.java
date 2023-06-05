package swp391.quizpracticing.dto;


import java.sql.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BlogDTO {
    private Integer id;
    private String title;
    private String content;
    private String thumbnail;
    private String briefInfo;
    private Date lastUpdated;
    private List<CategoryDTO>categories;
    private UserDTO author;
}
