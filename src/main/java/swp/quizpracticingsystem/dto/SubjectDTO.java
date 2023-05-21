package swp.quizpracticingsystem.dto;

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
public class SubjectDTO {
    private Integer idCourse;
    private CategoryDTO category;
    private List<UserDTO> expertId;
    private String courseName;
    private Date dateStart;
}
