package swp391.quizpracticing.serviceimple;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swp391.quizpracticing.service.IQuizreviewService;

/**
 *
 * @author Mosena
 */
@Service
public class QuizreviewService implements IQuizreviewService {
    @Autowired
    private ModelMapper modelMapper;


}

