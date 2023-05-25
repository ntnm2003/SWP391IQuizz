/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package swp.quizpracticingsystem.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<<<< Temporary merge branch 1
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import swp.quizpracticingsystem.model.Subject;
=========
import org.springframework.stereotype.Repository;
import swp.quizpracticingsystem.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
>>>>>>>>> Temporary merge branch 2

/**
 *
 * @author Mosena
 */
@Repository
<<<<<<<<< Temporary merge branch 1
public interface ISubjectRepository extends JpaRepository<Subject, Integer> {

    @Override
    public Page<Subject> findAll(Pageable pageable);
    
    @Override
    public List<Subject> findAll();

    @Query(value="Select * from `subject` s "
            + "join category c "
            + "on s.idCategory=c.id "
            + "where c.id = ?1", nativeQuery = true)
    public Page<Subject> findByCategory(Pageable pageable, int categoryId);

    @Query(value="Select * from `subject` s "
            + "where s.course_name like %?1%",nativeQuery = true)
    public Page<Subject> searchSubjectName(Pageable pageable, 
            String subjectName);
    
    @Query(value="Select * from `subject` s "
            + "join category c "
            + "on s.idCategory=c.id "
            + "where s.course_name like %?1% && c.id = ?2", nativeQuery = true)
    public Page<Subject>searchSubjectNameAndCategory(Pageable pageable, 
            String subjectName, int categoryId);
    
    Subject findByIdCourse(int id);
=========
public interface ISubjectRepository extends JpaRepository<Subject, Long> {

    @Override
    public Page<Subject> findAll(Pageable pageable);

    @Override
    public List<Subject> findAll();

    Subject findByIdCourse(int id);

>>>>>>>>> Temporary merge branch 2
}
