/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package swp391.quizpracticing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import swp391.quizpracticing.model.Pricepackage;

import java.util.List;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Mosena
 */
@Repository
public interface IPricepackageRepository 
        extends JpaRepository<Pricepackage,Integer> {    
    @Query("select p from Pricepackage p where p.subject.id= :id")
    public List<Pricepackage> getPricepackageBySubjects(Integer id);
}
