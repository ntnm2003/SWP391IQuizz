package swp.quizpracticingsystem.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "subject_detail")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDetail {
    @Id
    @Column(name = "idSub")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSub;

    @Column(name = "id_course")
    private Integer idCourse;
    
    @OneToOne
    @JoinColumn(name="id_course",referencedColumnName="idCourse")
    private Subject subject;
}
