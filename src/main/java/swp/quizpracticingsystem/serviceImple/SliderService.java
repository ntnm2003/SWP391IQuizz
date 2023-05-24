package swp.quizpracticingsystem.serviceImple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swp.quizpracticingsystem.dto.SliderDTO;
import swp.quizpracticingsystem.model.Slider;
import swp.quizpracticingsystem.repository.ISliderRepository;
import swp.quizpracticingsystem.service.ISliderSevice;

import java.util.ArrayList;
import java.util.List;

@Service
public class SliderService implements ISliderSevice {
    @Autowired
    private ISliderRepository sliderRepository;

    @Override
    public List<SliderDTO> getAllSlidersForHomepage() {
        List<Slider> sliders = sliderRepository.findAll();
        List<SliderDTO> results = new ArrayList<>();
        for (Slider slider : sliders) {
            SliderDTO sliderDTO = new SliderDTO();
            sliderDTO.sliderHomePage(slider);
            results.add(sliderDTO);
        }
        return results;
    }
}
