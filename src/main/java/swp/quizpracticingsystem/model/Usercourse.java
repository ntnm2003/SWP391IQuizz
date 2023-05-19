package swp.quizpracticingsystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
    @Column(name = "idCourse")
    private Integer idCourse;

    @Column(name = "idUser")
    private Integer idUser;
}
