package swp.quizpracticingsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import swp.quizpracticingsystem.model.PostCategory;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostCategoryDTO {
    private Integer postCategoryId;
    private String postCategory;
    private String postCategoryDescription;

    public Integer getPostCategoryId() {
        return postCategoryId;
    }

    public void setPostCategoryId(Integer postCategoryId) {
        this.postCategoryId = postCategoryId;
    }

    public String getPostCategory() {
        return postCategory;
    }

    public void setPostCategory(String postCategory) {
        this.postCategory = postCategory;
    }

    public String getPostCategoryDescription() {
        return postCategoryDescription;
    }

    public void setPostCategoryDescription(String postCategoryDescription) {
        this.postCategoryDescription = postCategoryDescription;
    }

    public void entityToDTO(PostCategory postCategory) {
        this.postCategoryId = postCategory.getPostCategoryId();
        this.postCategory = postCategory.getPostCategory();
        this.postCategoryDescription = postCategory.getPostCategoryDescription();
    }
}
