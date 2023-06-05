package swp391.quizpracticing.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "subcategory")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Subcategory {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private Boolean status;
    
    @ManyToOne
    @JoinColumn(name="category_id",referencedColumnName = "id")
    private Category category;
    
    @ManyToMany(mappedBy="subCategories")
    private List<Subject> subjects;
    
    @ManyToMany(mappedBy="subCategories")
    private List<Lesson> lessons;
    
    @ManyToMany(mappedBy="subCategories")
    private List<Question> questions;
}
