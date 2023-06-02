package swp391.quizpracticing.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pricepackage")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pricepackage {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "access_duration")
    private Integer accessDuration;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "list_price")
    private Float listPrice;

    @Column(name = "sale_price")
    private Float salePrice;

    @Column(name = "description")
    private String description;
    
    @ManyToMany(mappedBy = "pricePackages")
    private List<Subject> subjects;
    
    @OneToMany(mappedBy = "pricePackage")
    private List<UserSubject> userSubjects;
}
