/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package swp391.quizpracticing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import swp391.quizpracticing.model.Subcategory;
import swp391.quizpracticing.model.Subject;

import java.util.List;

/**
 *
 * @author Mosena
 */
@Repository
public interface ISubcategoryRepository 
        extends JpaRepository<Subcategory,Integer> {
    @Override
    public Subcategory save(Subcategory sc);

    public List<Subcategory> findBySubjects_Id(Integer subjectId);
}
