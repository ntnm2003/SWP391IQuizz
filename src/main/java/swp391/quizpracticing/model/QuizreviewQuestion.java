package swp391.quizpracticing.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "quizreview_question")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuizreviewQuestion {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="quizreview_id", referencedColumnName = "id")
    private Quizreview quizReview;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="question_id", referencedColumnName = "id")
    private Question question;

    @Column(name = "user_answer")
    private String userAnswer;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "bookmark")
    private Boolean bookmark;
}
