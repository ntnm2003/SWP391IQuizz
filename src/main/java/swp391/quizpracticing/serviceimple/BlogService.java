/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp391.quizpracticing.serviceimple;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import swp391.quizpracticing.dto.BlogDTO;
import swp391.quizpracticing.model.Blog;
import swp391.quizpracticing.model.Blogcategory;
import swp391.quizpracticing.repository.IBlogRepository;
import swp391.quizpracticing.service.IBlogService;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mosena
 */
@Service
public class BlogService implements IBlogService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IBlogRepository iBlogRepository;

    private BlogDTO convertEntityToDTO(Blog entity){
        return modelMapper.map(entity,BlogDTO.class);
    }

    @Override
    public List<BlogDTO> getAllBlogs() {
        List<BlogDTO> results = new ArrayList<>();
        List<Blog> posts = iBlogRepository.findAll();
        for(Blog post : posts) {
            BlogDTO blogDTO = new BlogDTO();
            blogDTO = convertEntityToDTO(post);
            results.add(blogDTO);
        }
        return results;

    }

    @Override
    public List<BlogDTO> getFeaturedPosts(boolean isFeatured) {
        List<Blog> featuredPosts = iBlogRepository.findByFeaturing(isFeatured);
        List<BlogDTO> results = new ArrayList<>();
        for(Blog post : featuredPosts) {
            BlogDTO postsDTO = new BlogDTO();
            postsDTO = convertEntityToDTO(post);
            results.add(postsDTO);
        }
        return results;

    }

    @Override
    public List<BlogDTO> getFeaturedLatestPosts(boolean isFeatured, int limit) {
        List<Blog> lastestPosts = iBlogRepository.findByFeaturingOrderByUpdatedDate(isFeatured, limit);
        List<BlogDTO> results = new ArrayList<>();
        for(Blog post : lastestPosts) {
            BlogDTO postsDTO = new BlogDTO();
            postsDTO = convertEntityToDTO(post);
            results.add(postsDTO);
        }
        return results;

    }

    @Override
    public List<BlogDTO> getLatestPosts(int limit) {
        List<Blog> lastestPosts = iBlogRepository.findByUpdatedDate(limit);
        List<BlogDTO> results = new ArrayList<>();
        for(Blog post : lastestPosts) {
            BlogDTO postsDTO = new BlogDTO();
            postsDTO = convertEntityToDTO(post);
            results.add(postsDTO);
        }
        return results;

    }

    @Override
    public Page<BlogDTO> getAllPostsWithPagination(int pageNo) {
        return null;
    }

    @Override
    public List<BlogDTO> searchByTitle(String searchTerm) {
        return null;
    }

    @Override
    public List<BlogDTO> getFilteredPosts(List<Blogcategory> categories) {
        return null;
    }
}
