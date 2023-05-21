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
@Table(name = "setting")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Setting {
    @Id
    @Column(name = "idquiz")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idQuiz;

    @Column(name = "number_of_quiz")
    private Integer numberOfQuiz;

    @Column(name = "quiz_type")
    private String quizType;
}
