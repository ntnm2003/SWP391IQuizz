package swp.quizpracticingsystem.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "quiz_review")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuizReview {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(name = "subject")
    private String subject;

    @Column(name = "idquiz")
    private Integer idQuiz;

    @Column(name = "score")
    private Integer score;

    @Column(name = "answer")
    private Boolean answer;
}
