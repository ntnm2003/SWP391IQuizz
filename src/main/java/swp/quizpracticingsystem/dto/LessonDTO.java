package swp.quizpracticingsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LessonDTO {
    private Integer idLesson;
    private Integer subjectId;
    private String lesson;
    private Integer lessonOrder;
    private String lessonType;
    private String status;
    private String action;
}
