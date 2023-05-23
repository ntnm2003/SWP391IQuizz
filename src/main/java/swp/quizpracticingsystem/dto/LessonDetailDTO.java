package swp.quizpracticingsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LessonDetailDTO {
    private Integer id;
    private String lessonName;
    private String lessonType;
    private String topic;
    private Integer lessonOrder;
    private String videoLink;
    private String content;
}
