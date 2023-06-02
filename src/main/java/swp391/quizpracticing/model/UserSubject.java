package swp391.quizpracticing.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id",referencedColumnName = "id")
    private Subject subject;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "price_package_id", referencedColumnName = "id")
    private Pricepackage pricePackage;

    @Column(name = "registration_time")
    private Timestamp registrationTime;

    @Column(name = "valid_from")
    private Timestamp validFrom;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "registration_status_id", referencedColumnName = "id")
    private Registrationstatus registrationStatus;
}
