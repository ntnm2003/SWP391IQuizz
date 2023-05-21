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
@Table(name = "slider")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Slider {
    @Id
    @Column(name = "slider_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sliderId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "title")
    private String title;

    @Column(name = "image")
    private String image;

    @Column(name = "backlink")
    private String backlink;

    @Column(name = "status")
    private String status;

    @Column(name = "visibility")
    private Boolean visibility;
}
