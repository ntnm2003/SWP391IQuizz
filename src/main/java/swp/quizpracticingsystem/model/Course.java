package swp.quizpracticingsystem.model;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "course")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @Column(name = "idCourse")
    private Integer idCourse;

    @Column(name = "idCategory")
    private Integer idCategory;

    @Column(name = "expert_id")
    private Integer expertId;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "dateStart")
    private LocalDate dateStart;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "category")
    private Category category;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "user")
    private User user;
    
}
