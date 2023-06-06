package swp391.quizpracticing.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SliderDTO {
    private Integer id;
    private String title;
    private String image;
    private String backLink;
    private Boolean status;

    public void sliderHomePage(Slider slider) {
        this.postId = post.getPostId();
        this.thumbnail = post.getThumbnail();
        this.title = post.getTitle();
        this.updatedDate = post.getUpdatedDate();
        this.briefInfor = post.getBriefInfor();
        PostCategoryDTO postCategoryDTO = new PostCategoryDTO();
        postCategoryDTO.entityToDTO(post.getPostCategory());
        this.postCategory = postCategoryDTO;
    }
}
