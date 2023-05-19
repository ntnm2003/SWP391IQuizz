
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
    private Integer idOverview;

    @Column(name = "idSub")
    private Integer idSub;

    @Column(name = "status")
    private boolean status;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private byte[] image;
}
