package swp.quizpracticingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import swp.quizpracticingsystem.NotFound.UserCourseKey;
import swp.quizpracticingsystem.model.Subject;
import swp.quizpracticingsystem.model.Usercourse;
import swp.quizpracticingsystem.repository.SubjectRepository;
import swp.quizpracticingsystem.repository.UserCourseRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserCourseService {
@Autowired private UserCourseRepo userCourseRepo;
@Autowired private SubjectRepository subjectRepository;
    public List<Usercourse> listAll() {

        return (List<Usercourse>) userCourseRepo.findAll();
    }

    public void save(Usercourse usercourse) {
        userCourseRepo.save(usercourse);
    }
    public Usercourse getId(UserCourseKey uk){
        return userCourseRepo.getUsercourseById(uk);
    }
    public List<Subject> courseById(Integer id) {
        List<Usercourse> userCourses = listAll();
        List<Usercourse> filteredUserCourses = new ArrayList<>(); // create a new list

        for (Usercourse uc : userCourses) {
            if (uc.getId().getUser_id() == id) {
                filteredUserCourses.add(uc); // add to the new list instead of original list
            }
        }

        List<Subject> subjects = new ArrayList<>();

        for (Usercourse userCourse : filteredUserCourses) { // iterate over the filtered list
            Subject sub = subjectRepository.getById(userCourse.getId().getIdcourse());
            subjects.add(sub);
        }

        return subjects;
    }


}
