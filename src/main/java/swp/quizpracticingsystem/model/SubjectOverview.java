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
    @Column(name = "idoverview")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOverview;

    @OneToOne
    @JoinColumn(name = "idsub",referencedColumnName = "idsub")
    private SubjectDetail subject;

    @Column(name = "status")
    private String status;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    @Column(name = "tag_line")
    private String tagLine;

    @Column(name = "featuring")
    private String featuring;
}
