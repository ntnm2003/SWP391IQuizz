package swp.quizpracticingsystem.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "slider_category")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SliderCategory {
    @Id
    @Column(name = "slider_catgory_id")
    private Integer sliderCatgoryId;

    @Column(name = "slider_category")
    private String sliderCategory;

    @Column(name = "slider_category_description")
    private String sliderCategoryDescription;
}
