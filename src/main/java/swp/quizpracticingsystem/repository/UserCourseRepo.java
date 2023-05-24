package swp.quizpracticingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import swp.quizpracticingsystem.NotFound.UserCourseKey;
import swp.quizpracticingsystem.model.Usercourse;

import java.util.List;
@Repository
public interface UserCourseRepo extends JpaRepository <Usercourse, UserCourseKey>{
    @Override
    public List<Usercourse> findAll();
    public Usercourse getUsercourseById(UserCourseKey uk);


  // public List<Subject> courseById(Integer id);
}
