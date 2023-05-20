package swp.quizpracticingsystem.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.sql.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "subject")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Subject {
    @Id
    @Column(name = "idCourse")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCourse;

    @Column(name = "idCategory")
    private Integer idCategory;

    @Column(name = "expert_id")
    private Integer expertId;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "dateStart")
    private Date dateStart;
    
    @OneToMany(mappedBy="lesson")
    private List<Lesson> lessons;
    
    @ManyToOne
    @JoinColumn(name="idCategory", referencedColumnName="id")
    private Category category;
    
    @OneToMany(mappedBy="user_id")
    private List<Usercourse> userCourses;
    
    @OneToOne
    @JoinColumn(name="idCourse", referencedColumnName="id_Course")
    private SubjectDetail subjectDetail;
    
    @ManyToMany
    @JoinTable(name="usercourse",
            joinColumns=
                    {@JoinColumn(name="user_id",referencedColumnName="idUser")},
            inverseJoinColumns=
                    {@JoinColumn(name="idUser",referencedColumnName="user_id")})
    private List<User> userCourse;
    
}
