package swp391.quizpracticing.service;

import swp391.quizpracticing.model.QuizreviewQuestion;

import java.util.List;

public interface IQuizreviewQuestionService {

    public List<QuizreviewQuestion> getAllByQuizreviewId(Integer id);
}
