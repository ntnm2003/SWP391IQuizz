/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package swp.quizpracticingsystem.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import swp.quizpracticingsystem.model.Course;

/**
 *
 * @author Mosena
 */
@Repository
public interface ISubjectRepository extends JpaRepository<Course, Long> {

    @Override
    public Page<Course> findAll(Pageable pageable);
    
    @Override
    public List<Course> findAll();
    
}
