package swp.quizpracticingsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubjectOverviewDTO {
    private Integer idOverview;
    private SubjectDTO subject;
    private String status;
    private String description;
    private String image;
    private String tagLine;
    private String featuring;

    public Integer getIdOverview() {
        return idOverview;
    }

    public void setIdOverview(Integer idOverview) {
        this.idOverview = idOverview;
    }

    public SubjectDTO getSubject() {
        return subject;
    }

    public void setSubject(SubjectDTO subject) {
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
