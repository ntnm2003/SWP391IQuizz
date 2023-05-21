package swp.quizpracticingsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DimensionDTO {
    private Integer id;
    private SubjectDTO subject;
    private String dimension;
    private String type;
}
