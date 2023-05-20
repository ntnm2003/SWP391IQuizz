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
@Table(name = "subject_overview")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubjectOverview {
    @Id
    @Column(name = "idOverview")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOverview;

    @Column(name = "idSub")
    private Integer idSub;

    @Column(name = "status")
    private String status;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;
    
    @OneToOne
    @JoinColumn(name="idSub",referencedColumnName="idSub")
    private SubjectDetail subjectDetail;
}
