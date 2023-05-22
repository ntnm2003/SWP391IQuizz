package swp.quizpracticingsystem.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "subject_overview")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubjectOverview {
    @Id
    @Column(name = "idoverview")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOverview;

    @OneToOne
    @JoinColumn(name = "idsub",referencedColumnName = "idsub")
    private SubjectDetail subject;

    @Column(name = "status")
    private String status;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    @Column(name = "tag_line")
    private String tagLine;

    @Column(name = "featuring")
    private String featuring;

    public Integer getIdOverview() {
        return idOverview;
    }

    public void setIdOverview(Integer idOverview) {
        this.idOverview = idOverview;
    }

    public SubjectDetail getSubject() {
        return subject;
    }

    public void setSubject(SubjectDetail subject) {
        this.subject = subject;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTagLine() {
        return tagLine;
    }

    public void setTagLine(String tagLine) {
        this.tagLine = tagLine;
    }

    public String getFeaturing() {
        return featuring;
    }

    public void setFeaturing(String featuring) {
        this.featuring = featuring;
    }
}
