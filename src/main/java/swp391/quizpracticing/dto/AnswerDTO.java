package swp391.quizpracticing.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDTO {
    private Integer id;
    private String rightAnswer;
    private String content;
    private String explaination;
    private Boolean status;
    private QuestionDTO question;
}
