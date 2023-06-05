package swp391.quizpracticing.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "dimension")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Dimension {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private Boolean status;

    @OneToMany(mappedBy="dimension")
    private List<Lesson> lessons;

    @OneToMany(mappedBy="dimension")
    private List<Subject> subjects;

    @OneToMany(mappedBy="dimension")
    private List<Question> questions;

    @OneToOne(mappedBy="dimension")
    private Settings setting;
}

