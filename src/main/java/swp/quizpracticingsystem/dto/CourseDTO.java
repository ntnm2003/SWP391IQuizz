package swp.quizpracticingsystem.dto;


import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {
    private Integer idCourse;
    private Integer idCategory;
    private Integer expertId;
    private String courseName;
    private LocalDate dateStart;
}
