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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "question")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "content")
    private Integer content;

    @Column(name = "answer_options")
    private String answerOptions;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "image")
    private String image;

    @Column(name = "audio")
    private String audio;

    @Column(name = "video")
    private String video;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "answer_id",referencedColumnName = "id")
    private Answer answer;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dimension_id",referencedColumnName = "id")
    private Dimension dimension;
    
    @ManyToMany(mappedBy = "questions")
    private List<Lesson> lessons;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_level_id",referencedColumnName = "id")
    private Level level;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "question_subcategory",
            joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "subcategory_id"))
    private List<Subcategory> subCategories;
    
    @OneToMany(mappedBy = "question")
    private List<QuizreviewQuestion> quizreviewQuestions;
}
