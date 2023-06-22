/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp391.quizpracticing.serviceimple;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swp391.quizpracticing.dto.BlogDTO;
import swp391.quizpracticing.dto.QuizreviewDTO;
import swp391.quizpracticing.model.Blog;
import swp391.quizpracticing.model.Quizreview;
import swp391.quizpracticing.repository.IQuizreviewRepository;
import swp391.quizpracticing.service.IQuizreviewService;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mosena
 */
@Service
public class QuizreviewService implements IQuizreviewService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IQuizreviewRepository iQuizreviewRepository;

    private QuizreviewDTO convertEntityToDTO(Quizreview entity){
        return modelMapper.map(entity,QuizreviewDTO.class);
    }

    @Override
    public List<QuizreviewDTO> getAllQuizreviewsByUserId(Integer userId) {
        List<Quizreview> quizreviewList = iQuizreviewRepository.findAllByUserId(userId);
        List<QuizreviewDTO> results = new ArrayList<>();

        for(Quizreview quiz : quizreviewList) {
            QuizreviewDTO quizreviewDTO = convertEntityToDTO(quiz);
            results.add(quizreviewDTO);
        }

        return results;
    }

    @Override
    public List<QuizreviewDTO> findByLessonId(Integer lessonId) {
        List<Quizreview> findByLessonId = iQuizreviewRepository.findAllByLessonId(lessonId);
        List<QuizreviewDTO> results = new ArrayList<>();

        for(Quizreview quiz : findByLessonId) {
            QuizreviewDTO quizreviewDTO = convertEntityToDTO(quiz);
            results.add(quizreviewDTO);
        }

        return results;
    }

}
