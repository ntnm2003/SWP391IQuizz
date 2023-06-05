package swp391.quizpracticing.serviceimple;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swp391.quizpracticing.service.IUserSubjectService;

/**
 *
 * @author Mosena
 */
@Service
public class UserSubjectService implements IUserSubjectService {
    @Autowired
    private ModelMapper modelMapper;

}

