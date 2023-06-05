package swp391.quizpracticing.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "systemsettings")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Systemsettings {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private Integer name;

    @Column(name = "status")
    private Integer status;
    
    @OneToOne(mappedBy = "systemSetting")
    private Settings setting;
}
