package swp.quizpracticingsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import swp.quizpracticingsystem.model.Slider;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SliderDTO {
    private Integer sliderId;
    private UserDTO user;
    private String title;
    private String image;
    private String backlink;
    private String status;
    private Boolean visibility;

    public Integer getSliderId() {
        return sliderId;
    }

    public void setSliderId(Integer sliderId) {
        this.sliderId = sliderId;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBacklink() {
        return backlink;
    }

    public void setBacklink(String backlink) {
        this.backlink = backlink;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getVisibility() {
        return visibility;
    }

    public void setVisibility(Boolean visibility) {
        this.visibility = visibility;
    }

    public void sliderHomePage(Slider slider) {
        this.image = slider.getImage();
        this.title = slider.getTitle();
        this.backlink = slider.getBacklink();
    }

    @Override
    public String toString() {
        return "SliderDTO{" +
                "sliderId=" + sliderId +
                ", user=" + user +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", backlink='" + backlink + '\'' +
                ", status='" + status + '\'' +
                ", visibility=" + visibility +
                '}';
    }
}
