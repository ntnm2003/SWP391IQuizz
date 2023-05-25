package swp.quizpracticingsystem.dto;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import swp.quizpracticingsystem.model.Posts;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostsDTO {
    private Integer postId;
    private UserDTO user;
    private String thumbnail;
    private PostCategoryDTO postCategory;
    private String title;
    private Date updatedDate;
    private String author;
    private String briefInfor;
    private String description;
    private String status;
    private Boolean featuring;

    public void postsHomePage(Posts post) {
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
