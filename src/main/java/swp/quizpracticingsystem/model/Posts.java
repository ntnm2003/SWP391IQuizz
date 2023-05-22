package swp.quizpracticingsystem.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @ManyToOne
    @JoinColumn(name="user_id",referencedColumnName = "user_id")
    private User user;

    @Column(name = "thumbnail")
    private String thumbnail;

    @ManyToOne
    @JoinColumn(name="post_category_id",referencedColumnName = "post_category_id")
    private PostCategory postCategory;

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
