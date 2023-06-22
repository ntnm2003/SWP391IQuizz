/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp391.quizpracticing.serviceimple;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import swp391.quizpracticing.dto.BlogDTO;
import swp391.quizpracticing.model.Blog;
import swp391.quizpracticing.model.Blogcategory;
import swp391.quizpracticing.repository.IBlogRepository;
import swp391.quizpracticing.service.IBlogService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Mosena
 */
@Service
public class BlogService implements IBlogService {
    public static final int BLOGS_PER_PAGE = 4;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IBlogRepository iBlogRepository;
    private BlogDTO convertEntityToDTO(Blog entity){
        return modelMapper.map(entity,BlogDTO.class);
    }

    @Override
    public List<BlogDTO> getAllBlog() {
        List<Blog> blogs = iBlogRepository.findAll();
        return blogs
                .stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }
    @Override
    public List<BlogDTO> getFeaturedBlog(boolean isFeatured) {
        List<Blog> featuredBlog = iBlogRepository.findByFeaturing(isFeatured);
        return featuredBlog
                .stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }


    @Override
    public Page<Blog> getAllBlogsWithPagination(int pageNo) {
        Page<Blog> blogs = iBlogRepository.findAll(PageRequest.of(pageNo, BLOGS_PER_PAGE));
        return blogs;
    }

    @Override
    public List<BlogDTO> searchBlogByTitle(String searchTerm) {
        List<Blog> searchedBlog = iBlogRepository.findByTitleContainingIgnoreCase(searchTerm);
        return searchedBlog
                .stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Blog getBlogById(Integer id) {
        return iBlogRepository.findById(id).get();

    }

    @Override
    public List<BlogDTO> getFeaturedLatestBlog(boolean isFeatured, int limit) {
        List<Blog> latestBlog = iBlogRepository.findByFeaturingOrderByUpdatedDate(isFeatured, limit);
        return latestBlog
                .stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());

    }

    @Override
    public List<BlogDTO> getLatestBlog(int limit) {
        List<Blog> latestBlog = iBlogRepository.findByUpdatedDate(limit);
        return latestBlog
                .stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<BlogDTO> getFilteredBlog(List<Blogcategory> categories) {
        return null;
    }

}
