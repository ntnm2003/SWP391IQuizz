package swp.quizpracticingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import swp.quizpracticingsystem.model.Slider;

public interface ISliderRepository extends JpaRepository<Slider, Integer> {

}