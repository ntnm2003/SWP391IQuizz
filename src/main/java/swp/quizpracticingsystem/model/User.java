package swp.quizpracticingsystem.model;


import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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

    @Column(name = "fullname")
    private String fullName;

    @Column(name = "Email")
    private String email;

    @Column(name = "Gender")
    private Boolean gender;

    @Column(name = "Mobile")
    private String mobile;

    @Column(name = "Password")
    private String password;

<<<<<<<<< Temporary merge branch 1
    @Column(name = "token")
    private String token;
    
    
    private Boolean enabled;
=========
    @Column(name = "token", nullable = true)
    private String token;
>>>>>>>>> Temporary merge branch 2

    @Column(name = "lastupdatedatetime", nullable = true)
    private String lastupdatedatetime;

<<<<<<<<< Temporary merge branch 1

    
=========
    @Column(name = "enabled", nullable = false)
    private Boolean enabled;
>>>>>>>>> Temporary merge branch 2


    @ManyToOne
    @JoinColumn(name = "role_id",referencedColumnName = "role_id")
    private Role role;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "Usercourse",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "idcourse")})
    private Set<Subject> subjects = new HashSet<>();
<<<<<<<<< Temporary merge branch 1
    public User token(String token) {
        setToken(token);
        return this;
    }
    
    public User lastupdatedatetime(String lastUpdateDateTime) {
        setLastupdatedatetime(lastUpdateDateTime);
        return this;
    }
}

=========
}
>>>>>>>>> Temporary merge branch 2
