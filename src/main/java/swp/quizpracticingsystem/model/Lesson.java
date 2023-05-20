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
@Table(name = "lesson")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Lesson {
    @Id
    @Column(name = "idLesson")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLesson;

    @Column(name = "idCourse")
    private Integer idCourse;

    @Column(name = "lesson")
    private String lesson;

    @Column(name = "lesson_order")
    private Integer lessonOrder;

    @Column(name = "lesson_type")
    private String lessonType;

    @Column(name = "status")
    private String status;

    @Column(name = "action")
    private String action;
}
