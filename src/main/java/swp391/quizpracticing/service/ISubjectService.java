/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package swp391.quizpracticing.service;

import org.springframework.data.domain.Page;
import swp391.quizpracticing.dto.SubjectDTO;
import swp391.quizpracticing.model.Subject;

import java.util.List;

/**
 * @author Mosena
 */
public interface ISubjectService {
    public Page<SubjectDTO> findPaginatedAllSubjects(int pageNo, int pageSize);

    public Page<SubjectDTO> filterSubjectByCategory(int pageNo,
                                                    int pageSize, int category);

    public Page<SubjectDTO> findSubjectBySubjectName(int pageNo,
                                                     int pageSize, String subjectName);

    public Page<SubjectDTO> findSubjectNameAndFilter(int pageNo, int pageSize,
                                                     String subjectName, int categoryId);

    public Page<SubjectDTO> sortSubjectBy(int pageNo, int pageSize,
                                          String sortBy, String order);

    public Page<SubjectDTO> filterAndSortSubject(int pageNo, int pageSize,
                                                 int category, String sortBy, String order);

    public Page<SubjectDTO> searchAndSortSubject(int pageNo, int pageSize,
                                                 String subjectName, String sortBy, String order);

    public Page<SubjectDTO> filterAndSearchAndSortSubject(int pageNo,
                                                          int pageSize, int category, String subjectName,
                                                          String sortBy, String order);

    List<Subject> findByFeaturing(Boolean isFeatured);

    public List<Subject> listAll();

    public List<Subject> searchByCourseName(String s);

    public void save(Subject subject);

    public Subject getById(int id);

    public List<Subject> findSubjectsWithSorting(String field);

    public Page<Subject> findSubjectsWithPagination(int pageNum, int itemPerPage);

    public Page<Subject> findSubjectsWithPaginationByExpertId(Integer id, int pageNum, int itemPerPage);

    public Page<Subject> findSubjectsWithPaginationAndSorting(int pageNum, int itemPerPage, String field);

    public Page<Subject> searchForSubjectsByName(int pageNum, int itemPerPage, String searchTerm);

}
