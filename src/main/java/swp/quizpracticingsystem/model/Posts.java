package swp.quizpracticingsystem.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "posts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Posts {
    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "thumbnail")
    private String thumbnail;

    @Column(name = "post_category_id")
    private Integer postCategoryId;

    @Column(name = "title")
    private String title;

    @Column(name = "updated_date")
    private Date updatedDate;

    @Column(name = "author")
    private String author;

    @Column(name = "brief_infor")
    private String briefInfor;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status;

    @Column(name = "featuring")
    private Boolean featuring;
}
