package swp391.quizpracticing.model;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.sql.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "gender")
    private Boolean gender;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "token")
    private String token;

    @Column(name = "last_update_date")
    private Date lastUpdateDate;

    @Column(name = "enable")
    private Boolean enable;
    
    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    private List<Blog> blogs;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id",referencedColumnName = "id")
    private Role role;
    
    @OneToOne(mappedBy = "owner")
    private Subject subject;
    
    @OneToMany(mappedBy = "creator")
    private List<Lesson> lessons;
    
    @OneToMany(mappedBy = "user")
    private List<Quizreview> quizReviews;
    
    @OneToMany(mappedBy = "user")
    private List<UserSubject> userSubjects;
}
