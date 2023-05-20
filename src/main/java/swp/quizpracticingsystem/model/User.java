package swp.quizpracticingsystem.model;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(name = "FullName")
    private String fullName;

    @Column(name = "Email")
    private String email;

    @Column(name = "Gender")
    private Boolean gender;

    @Column(name = "Mobile")
    private String mobile;

    @Column(name = "Password")
    private String password;

    @Column(name = "role_id")
    private Integer roleId;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="role_id", referencedColumnName = "role_id")
    private Role role;
    
    @OneToOne
    @JoinColumn(name="user_id",referencedColumnName="user_profile_id")
    private Userprofile userprofile;
    
    @OneToMany(mappedBy="slider")
    private List<Slider> slider;
    
    @OneToOne
    @JoinColumn(name="user_id",referencedColumnName="idUser" )
    private Usercourse userCourse;
    
    @OneToOne
    @JoinColumn(name="user_id",referencedColumnName="user_id")
    private QuizReview quizReview;
    
    @OneToMany(mappedBy="posts")
    private List<Posts> posts;
}
