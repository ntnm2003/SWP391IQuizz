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
    @Column(name = "idsub")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSub;

    @OneToOne
    @JoinColumn(name = "id_course", referencedColumnName = "idcourse")
    private Subject subject;

    public Integer getIdSub() {
        return idSub;
    }

    public void setIdSub(Integer idSub) {
        this.idSub = idSub;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
