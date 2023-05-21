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
@Table(name = "usercourse")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usercourse {
    @Id
    @Column(name = "idcourse")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCourse;

    @OneToOne
    @JoinColumn(name = "iduser",referencedColumnName = "user_id")
    private User user;

    @Column(name = "status")
    private String status;

}
