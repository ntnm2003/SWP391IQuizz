package swp391.quizpracticing.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import swp391.quizpracticing.dto.LessonDTO;
import swp391.quizpracticing.dto.QuizreviewDTO;
import swp391.quizpracticing.dto.SubjectDTO;
import swp391.quizpracticing.model.*;
import swp391.quizpracticing.repository.ILessonRepository;
import swp391.quizpracticing.repository.IQuizreviewQuestionRepository;
import swp391.quizpracticing.service.ILessonService;
import swp391.quizpracticing.service.IQuestionService;
import swp391.quizpracticing.service.IQuizreviewQuestionService;
import swp391.quizpracticing.service.IQuizreviewService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PracticeListController {

    @Autowired
    private IQuizreviewService iQuizreviewService;

    @Autowired
    private ILessonService iLessonService;

    @Autowired
    private IQuizreviewQuestionService iQuizreviewQuestionService;

    @Autowired
    private IQuestionService iQuestionService;

    @GetMapping("/practice-list")
    public String getToPracticeList(Model model, HttpSession session) {
        //Logged in User (using Session)
        User loggedinUser = (User)session.getAttribute("user");
        System.out.println(loggedinUser);

        //Get all the Taken Quizzes of the respective user
        List<QuizreviewDTO> takenQuizzes = iQuizreviewService.getAllQuizreviewsByUserId(loggedinUser.getId());
        System.out.println("takenQuizzes size: " + takenQuizzes.size());

        //Get the respective subject of the Taken Quizzes
        List<SubjectDTO> takenQuizSubjects = new ArrayList<>();
        List<LessonDTO> lessons = new ArrayList<>();
        for(QuizreviewDTO takenQuiz : takenQuizzes) {
            LessonDTO lesson = iLessonService.findById(takenQuiz.getLesson().getId());
            lessons.add(lesson);
        }
        for(LessonDTO lesson2 : lessons) {
            SubjectDTO subject = lesson2.getSubject();
            takenQuizSubjects.add(subject);
        }
        for(SubjectDTO subjectDTO: takenQuizSubjects) {
            System.out.println("takenQuizSubjects ids: " + subjectDTO.getId());
        }

        //Get the test_type of the Taken Quizzes (Practice Test or Simulation Exam)
        //Get the level, dimension of the Taken Quizzes

        //Get the questions and user_answers of the Take Quizzes
        //Get list user_answer (list of question in the Take Quiz)
        for(QuizreviewDTO takenQuiz : takenQuizzes) {
            System.out.println(takenQuiz.getQuizreviewQuestions().size());
        }
        System.out.println();
        //Get list questions respective
        //Get list question answer respective

        //Get all quizreview_question of the respective Taken Quizzes (get all of the associated users)
        List<QuizreviewQuestion> quizreviewQuestions = new ArrayList<>();
        for(QuizreviewDTO takenQuiz : takenQuizzes) {
            List<QuizreviewQuestion> quizreviewQuestions1 = iQuizreviewQuestionService.getAllByQuizreviewId(takenQuiz.getId());
            quizreviewQuestions.addAll(quizreviewQuestions1);
        }



        //Get all the user_answer of the quizreview_question by quizreview_id


        //Get all the question of the quizreview_question by quizreview_id
        //Get questions by ids
        List<Question> quizreviewQuestionContent = new ArrayList<>();
        for(QuizreviewQuestion quizreviewQuestion : quizreviewQuestions) {
            Question p = quizreviewQuestion.getId().getQuestion();
            quizreviewQuestionContent.add(p);
        }

        //Get all answers by the questions
        List<Answer> quizreviewQuestionAnswer = new ArrayList<>();
        for(Question question : quizreviewQuestionContent) {
            List<Answer> answers = question.getAnswer();
            quizreviewQuestionAnswer.addAll(answers);
        }

        //Check if the user_answer is equal to question_answer
        int numberofCorrectness = 0;



        model.addAttribute("takenQuizzes", takenQuizzes);
        model.addAttribute("takenQuizSubjects", takenQuizSubjects);
        model.addAttribute("takenQuizLessons", lessons);

        return "practice_list/practice_list";
    }

    @GetMapping("/searchPractice")
    public String searchByPracticeName(@RequestParam(name = "practice-name") String practiceName, Model model, HttpSession session) {

        User loggedinUser = (User)session.getAttribute("user");

        if(practiceName.isEmpty()) {
            model.addAttribute("examName", practiceName);
            return "redirect:/practice-list";
        } else {

        }


        return "practice_list/practice_list";
    }
}
