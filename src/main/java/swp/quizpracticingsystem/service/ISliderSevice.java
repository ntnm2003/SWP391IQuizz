package swp.quizpracticingsystem.service;

import org.springframework.data.jpa.repository.JpaRepository;
import swp.quizpracticingsystem.dto.SliderDTO;
import swp.quizpracticingsystem.model.Slider;

import java.util.List;

public interface ISliderSevice {
    List<SliderDTO> getAllSlidersForHomepage();
}
