/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp391.quizpracticing.serviceimple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import swp391.quizpracticing.dto.BlogDTO;
import swp391.quizpracticing.model.Blog;
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
    public static final int POSTS_PER_PAGE = 4;

    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<BlogDTO> getAllBlog() {
        List<BlogDTO> results = new ArrayList<>();
        List<Blog> blogs = blogRepository.findAll();
        for(Blog blog : blogs) {
            BlogDTO blogDTO = new BlogDTO();
            blogDTO.blogHomePage(blog);
            results.add(blogDTO);
        }
        return results;
    }
//    @Override
//    public List<BlogDTO> getFeaturedBlog(boolean isFeatured) {
//        List<Blog> featuredBlog = iBlogRepository.findByFeaturing(isFeatured);
//        List<BlogDTO> results = new ArrayList<>();
//        for(Blog blog : featuredBlog) {
//            BlogDTO blogDTO = new BlogDTO();
//            blogDTO.blogHomePage(blog);
//            results.add(blogDTO);
//        }
//        return results;
//    }


    @Override
    public Page<Blog> getAllBlogWithPagination(int pageNo) {
//		Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Blog> blog = blogRepository.findAll(PageRequest.of(pageNo, POSTS_PER_PAGE));

        return blog;
    }

    @Override
    public List<BlogDTO> searchBlogByTitle(String searchTerm) {
        List<BlogDTO> results = new ArrayList<>();
        List<Blog> searchedBlog = blogRepository.findByTitleContainingIgnoreCase(searchTerm);
        for(Blog blog : searchedBlog) {
            BlogDTO blogDTO = new BlogDTO();
            blogDTO.blogHomePage(blog);
            results.add(blogDTO);
        }
        return results;
    }

//    @Override
//    public List<BlogDTO> getFilteredBlog(List<Blogcategory> categories) {
//        return null;
//    }

//    @Override
//    public List<BlogDTO> getFilteredBlog(List<Blogcategory> categories) {
//        List<Blog> filteredBlog = iBlogRepository.findByCategoryIn(categories);
//        List<BlogDTO> results = new ArrayList<>();
//        for(Blog blog : filteredBlog) {
//            BlogDTO blogDTO = new BlogDTO();
//            blogDTO.blogHomePage(blog);
//            results.add(blogDTO);
//        }
//
//        return results;
//    }
    @Override
    public Blog getBlogById(Integer id) {
        return blogRepository.findById(id).get();
    }

}
