package swp.quizpracticingsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuizOverviewDTO {
    private Integer idQuiz;
    private String name;
    private String subject;
    private String level;
    private Integer duration;
    private Integer passRate;
    private String quizType;
    private String description;
}
