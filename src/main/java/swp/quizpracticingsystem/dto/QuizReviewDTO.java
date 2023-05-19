package swp.quizpracticingsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuizReviewDTO {
    private Integer userId;
    private String subject;
    private Integer idQuiz;
    private Integer score;
    private boolean answer;
}
