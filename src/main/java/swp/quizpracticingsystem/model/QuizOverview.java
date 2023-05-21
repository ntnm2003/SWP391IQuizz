
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
@Table(name = "quiz_overview")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuizOverview {
    @Id
    @Column(name = "idquiz")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idQuiz;

    @Column(name = "name")
    private String name;

    @Column(name = "subject")
    private String subject;

    @Column(name = "level")
    private String level;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "pass_rate")
    private Integer passRate;

    @Column(name = "quiz_type")
    private String quizType;

    @Column(name = "description")
    private String description;
}
