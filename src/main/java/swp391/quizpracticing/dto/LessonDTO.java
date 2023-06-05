package swp391.quizpracticing.dto;

import java.sql.Time;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LessonDTO {
    private Integer id;
    private LessontypeDTO lessonType;
    private TesttypeDTO testType;
    private DimensionDTO dimension;
    private Integer name;
    private Integer order;
    private Boolean status;
    private Double passRate;
    private Time duration;
    private Integer questionNumber;
    private LevelDTO level;
    private String topic;
    private String videoLink;
    private String htmlContent;
    private UserDTO creator;
    private SubjectDTO subject;
    private List<QuestionDTO> questions;
    private List<SubcategoryDTO> subCategories;
    private List<QuizreviewDTO> quizReviews;
}
