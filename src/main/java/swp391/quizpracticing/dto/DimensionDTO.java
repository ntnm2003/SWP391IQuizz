package swp391.quizpracticing.dto;

import java.util.List;
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
    private String name;
    private String type;
    private String description;
    private Boolean status;
    private List<LessonDTO> lessons;
    private List<SubjectDTO> subjects;
    private List<QuestionDTO> questions;
    private SettingsDTO setting;
}
