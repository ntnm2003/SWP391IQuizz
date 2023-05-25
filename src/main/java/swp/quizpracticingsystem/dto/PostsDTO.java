package swp.quizpracticingsystem.dto;

import java.sql.Date;
import swp.quizpracticingsystem.model.Posts;


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
    }

    public PostsDTO() {
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public PostCategoryDTO getPostCategory() {
        return postCategory;
    }

    public void setPostCategory(PostCategoryDTO postCategory) {
        this.postCategory = postCategory;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBriefInfor() {
        return briefInfor;
    }

    public void setBriefInfor(String briefInfor) {
        this.briefInfor = briefInfor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getFeaturing() {
        return featuring;
    }

    public void setFeaturing(Boolean featuring) {
        this.featuring = featuring;
    }

    @Override
    public String toString() {
        return "PostsDto [postId=" + postId + ", thumbnail=" + thumbnail + ", title=" + title
                + ", updatedDate=" + updatedDate + ", author=" + author + ", briefInfor=" + briefInfor
                + ", description=" + description + "]";
    }
}
