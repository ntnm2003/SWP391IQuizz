package swp391.quizpracticing.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "dimension")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Dimension {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private Boolean status;
    
    @OneToMany(mappedBy="dimension")
    private List<Lesson> lessons;
    
    @OneToMany(mappedBy="dimension")
    private List<Subject> subjects;
    
    @OneToMany(mappedBy="dimension")
    private List<Question> questions;
    
    @OneToOne(mappedBy="dimension")
    private Settings setting; 
}
