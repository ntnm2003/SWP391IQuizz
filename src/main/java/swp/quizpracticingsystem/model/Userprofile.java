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
@Table(name = "userprofile")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Userprofile {
    @Id
    @Column(name = "user_profile_id")
    private Integer userProfileId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "avatar")
    private byte[] avatar;

    @Column(name = "Headline")
    private String headline;
}
