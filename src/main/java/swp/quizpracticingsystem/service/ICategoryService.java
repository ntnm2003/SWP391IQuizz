package swp.quizpracticingsystem.service;

import swp.quizpracticingsystem.model.Category;

import java.util.List;

public interface ICategoryService {


    public List<Category> listAll() ;
    public Category getById(Integer id) ;
}
