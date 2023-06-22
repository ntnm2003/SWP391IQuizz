/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package swp391.quizpracticing.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import swp391.quizpracticing.model.Subject;

import java.util.List;

/**
 *
 * @author Mosena
 */
@Repository
public interface ISubjectRepository extends JpaRepository<Subject,Integer> {
    @Override
    public Page<Subject> findAll(Pageable pageable);

    public List<Subject> findAllByFeatured(Boolean isFeatured);

    public Subject findByLessons_Id(Integer id);
    @Override
    public List<Subject> findAll();

    public Subject findById(int id);

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

    //Subject findByIdCourse(int id);
    //Subject findByIdCourse(Integer id);

    //List<Subject> findByCourseNameContaining(String s);

}
