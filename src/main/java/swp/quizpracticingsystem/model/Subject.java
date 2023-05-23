package swp.quizpracticingsystem.model;


import jakarta.persistence.*;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "subject")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Subject {
    @Id
    @Column(name = "idcourse")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCourse;

    @ManyToOne
    @JoinColumn(name="idcategory", referencedColumnName = "id")
    private Category category;

    @ManyToOne
    @JoinColumn(name="expert_id",referencedColumnName = "user_id")
    private User expert;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "datestart")
    private Date dateStart;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "subjects")
    private Set<User> users = new HashSet<>();
}
