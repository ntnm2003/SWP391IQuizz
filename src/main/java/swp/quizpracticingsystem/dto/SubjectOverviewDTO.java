package swp.quizpracticingsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubjectOverviewDTO {
    private Integer idOverview;
    private SubjectDTO subject;
    private String status;
    private String description;
    private String image;
    private String tagLine;
    private String featuring;
}
