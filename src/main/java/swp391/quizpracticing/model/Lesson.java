package swp391.quizpracticing.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.List;
import java.sql.Time;
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
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private Integer name;

    @Column(name = "`order`")
    private Integer order;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "pass_rate")
    private Double passRate;

    @Column(name = "duration")
    private Time duration;

    @Column(name = "question_number")
    private Integer questionNumber;

    @Column(name = "topic")
    private String topic;

    @Column(name = "video_link")
    private String videoLink;

    @Column(name = "html_content")
    private String htmlContent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id",referencedColumnName = "id")
    private Subject subject;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dimension_id",referencedColumnName = "id")
    private Dimension dimension;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "lesson_question", 
            joinColumns = @JoinColumn(name = "lesson_id"),
            inverseJoinColumns = @JoinColumn(name = "question_id"))
    private List<Question> questions;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lesson_type_id",referencedColumnName = "id")
    private Lessontype lessonType;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_type_id",referencedColumnName = "id")
    private Testtype testType;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "level_id",referencedColumnName = "id")
    private Level level;
    
    @OneToMany(mappedBy = "lesson")
    private List<Quizreview> quizReviews;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "lesson_subcategory",
            joinColumns = @JoinColumn(name = "lesson_id"),
            inverseJoinColumns = @JoinColumn(name = "subcategory_id"))
    private List<Subcategory> subCategories;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_id",referencedColumnName = "id")
    private User creator;
}
