package swp.quizpracticingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swp.quizpracticingsystem.NotFound.UserCourseKey;
import swp.quizpracticingsystem.model.Subject;
import swp.quizpracticingsystem.model.Usercourse;
import swp.quizpracticingsystem.repository.ISubjectRepository;
import swp.quizpracticingsystem.repository.IUserCourseRepo;

import java.util.ArrayList;
import java.util.List;


public interface IUserCourseService {

    public List<Usercourse> listAll() ;
    public void save(Usercourse usercourse) ;
    public Usercourse getId(UserCourseKey uk);
    public List<Subject> courseById(Integer id);



}
