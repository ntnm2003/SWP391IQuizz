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
import java.util.HashMap;
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

        //Get all the Taken Quizzes of the respective user
        List<QuizreviewDTO> takenQuizzes = iQuizreviewService.getAllQuizreviewsByUserId(loggedinUser.getId());

        //Get the respective subject of the Taken Quizzes
        List<SubjectDTO> takenQuizSubjects = new ArrayList<>();
        List<LessonDTO> lessons = new ArrayList<>();  //lessons respective to the quizreview
        for(QuizreviewDTO takenQuiz : takenQuizzes) {
            LessonDTO lesson = iLessonService.findById(takenQuiz.getLesson().getId());
            lessons.add(lesson);
        }
        for(LessonDTO lesson2 : lessons) {
            SubjectDTO subject = lesson2.getSubject();
            takenQuizSubjects.add(subject);
        }

        //Get the test_type of the Taken Quizzes (Practice Test or Simulation Exam)
        //Get the level, dimension of the Taken Quizzes

        //Using HashMap to store quizreviewId and numberOfCorrect (quizreviewQuestion)
        HashMap<Integer, Integer> quizreviewQuestionHashMap = new HashMap<>();

        for(QuizreviewDTO takenQuiz : takenQuizzes) {
            Integer correct = iQuizreviewQuestionService.getNumberOfCorrectAnswerByQuizreviewId(takenQuiz.getId(), true);
            System.out.println("takenQuiz id: " + takenQuiz.getId() + ", correct: " + correct);
            quizreviewQuestionHashMap.put(takenQuiz.getId(), correct);
        }

        //Get the correctness in percent
        List<Double> percentCorrect = new ArrayList<>();
        for(QuizreviewDTO takeQUiz : takenQuizzes) {
            double percent = (double) quizreviewQuestionHashMap.get(takeQUiz.getId()) / takeQUiz.getLesson().getQuestionNumber();
            System.out.println(percent);
            percentCorrect.add(percent*100);
        }

        model.addAttribute("takenQuizzes", takenQuizzes);
        model.addAttribute("takenQuizSubjects", takenQuizSubjects);
        model.addAttribute("takenQuizLessons", lessons);
        model.addAttribute("hashmaps", quizreviewQuestionHashMap);
        model.addAttribute("percentCorrect", percentCorrect);

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
