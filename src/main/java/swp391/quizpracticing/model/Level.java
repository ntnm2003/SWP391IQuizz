package swp391.quizpracticing.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "level")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Level {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private Boolean status;

    @OneToMany(mappedBy = "level")
    private List<Lesson> lessons;

    @OneToOne(mappedBy = "level")
    private Settings setting;

    @OneToMany(mappedBy = "level")
    private List<Question> questions;
}


