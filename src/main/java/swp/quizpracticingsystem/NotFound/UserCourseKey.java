package swp.quizpracticingsystem.NotFound;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class UserCourseKey implements Serializable {
    @Column(name = "user_id")
    private Integer user_id;

    @Column(name = "idcourse")
    private Integer idcourse;

    @Override
    public String toString() {
        return idcourse+""+user_id;
    }

    // Constructors, getters and setters
}