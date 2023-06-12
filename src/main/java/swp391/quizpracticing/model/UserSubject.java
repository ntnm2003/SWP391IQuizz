package swp391.quizpracticing.model;


import jakarta.persistence.*;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_subject")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserSubject {
    @EmbeddedId
    private UserSubjectKey id;

    @Column(name = "registration_time")
    private Timestamp registrationTime;

    @Column(name = "valid_from")
    private Timestamp validFrom;
    
    @Column(name = "valid_to")
    private Timestamp validTo;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "registration_status_id", referencedColumnName = "id")
    private Registrationstatus registrationStatus;
}
