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
public class SubjectDTO {
    private Integer idCourse;
    private Integer idCategory;
    private Integer expertId;
    private String courseName;
    private Date dateStart;
}
