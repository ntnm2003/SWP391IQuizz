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
@Table(name = "lesson_detail")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LessonDetail {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "lesson_name")
    private String lessonName;

    @Column(name = "lesson_type")
    private String lessonType;

    @Column(name = "topic")
    private String topic;

    @Column(name = "lesson_order")
    private Integer lessonOrder;

    @Column(name = "video_link")
    private String videoLink;

    @Column(name = "content")
    private String content;
}
