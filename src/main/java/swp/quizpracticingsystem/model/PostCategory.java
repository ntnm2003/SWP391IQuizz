package swp.quizpracticingsystem.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "post_category")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostCategory {
    @Id
    @Column(name = "post_category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postCategoryId;

    @Column(name = "post_category")
    private String postCategory;

    @Column(name = "post_category_description")
    private String postCategoryDescription;
}
