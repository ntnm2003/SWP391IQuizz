package swp391.quizpracticing.serviceimple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swp391.quizpracticing.model.QuizreviewQuestion;
import swp391.quizpracticing.repository.IQuizreviewQuestionRepository;
import swp391.quizpracticing.service.IQuizreviewQuestionService;

import java.util.List;

@Service
public class QuizreviewQuestionService implements IQuizreviewQuestionService {

    @Autowired
    private IQuizreviewQuestionRepository iQuizreviewQuestionRepository;

    @Override
    public List<QuizreviewQuestion> getAllByQuizreviewId(Integer id) {
        return iQuizreviewQuestionRepository.getAllByQuizreviewId(id);
    }
}
