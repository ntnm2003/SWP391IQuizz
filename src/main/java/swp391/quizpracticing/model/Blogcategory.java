package swp391.quizpracticing.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "blogcategory")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Blogcategory {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private Boolean status;
    
    @ManyToMany(mappedBy="categories")
    private List<Blog> blogs;
    
    @OneToOne(mappedBy = "blogcategory")
    private Settings setting;
}
