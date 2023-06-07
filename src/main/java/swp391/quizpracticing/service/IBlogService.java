/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package swp391.quizpracticing.service;

import org.springframework.data.domain.Page;
import swp391.quizpracticing.dto.BlogDTO;
import swp391.quizpracticing.dto.BlogcategoryDTO;
import swp391.quizpracticing.model.Blogcategory;

import java.util.List;

/**
 *
 * @author Mosena
 */
public interface IBlogService {
    List<BlogDTO> getAllBlogs();

    List<BlogDTO> getFeaturedPosts(boolean isFeatured);

    List<BlogDTO> getFeaturedLatestPosts(boolean isFeatured, int limit);

    List<BlogDTO> getLatestPosts(int limit);

    Page<BlogDTO> getAllPostsWithPagination(int pageNo);

    List<BlogDTO> searchByTitle(String searchTerm);

    List<BlogDTO> getFilteredPosts(List<Blogcategory> categories);

}
