package swp.quizpracticingsystem.model;


import java.sql.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import swp.quizpracticingsystem.NotFound.UserCourseKey;

@Entity
@Table(name = "usercourse")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Usercourse {
    @EmbeddedId
    private UserCourseKey id;

    @Column(name = "status")
    private String status;

    @Column(name = "date_register")
    private Date dateRegister;

    @Column(name = "price_package")
    private Integer price;
}
