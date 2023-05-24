package swp.quizpracticingsystem.serviceImple;

import org.springframework.stereotype.Service;
import swp.quizpracticingsystem.NotFound.UserCourseKey;
import swp.quizpracticingsystem.model.Subject;
import swp.quizpracticingsystem.model.Usercourse;
import swp.quizpracticingsystem.repository.ISubjectRepository;
import swp.quizpracticingsystem.repository.IUserCourseRepo;
import swp.quizpracticingsystem.service.IUserCourseService;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserCourseService implements IUserCourseService {
    private final IUserCourseRepo userCourseRepo;
    private final ISubjectRepository subjectRepository;

    public UserCourseService(IUserCourseRepo userCourseRepo, ISubjectRepository subjectRepository) {
        this.userCourseRepo = userCourseRepo;
        this.subjectRepository = subjectRepository;
    }

    @Override
    public List<Usercourse> listAll() {
        return (List<Usercourse>) userCourseRepo.findAll();
    }

    @Override
    public void save(Usercourse usercourse) {
        userCourseRepo.save(usercourse);
    }

    @Override
    public Usercourse getId(UserCourseKey uk) {
        return userCourseRepo.getUsercourseById(uk);
    }

    @Override
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
