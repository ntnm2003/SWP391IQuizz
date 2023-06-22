/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp391.quizpracticing.serviceimple;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import swp391.quizpracticing.dto.SubjectDTO;
import swp391.quizpracticing.model.Subject;
import swp391.quizpracticing.repository.ISubjectRepository;
import swp391.quizpracticing.service.ISubjectService;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mosena
 */
@Service
public class SubjectService implements ISubjectService {
    @Autowired
    private ModelMapper modelMapper;

    private ISubjectRepository subjectRepository;

    @Autowired
    private ISubjectRepository iSubjectRepository;

    private SubjectDTO convertEntityToDTO(Subject entity){
        return modelMapper.map(entity,SubjectDTO.class);
    }

    @Override
    public Page<SubjectDTO> findPaginatedAllSubjects(int pageNo, int pageSize) {
        return null;
    }

    @Override
    public Page<SubjectDTO> filterSubjectByCategory(int pageNo, int pageSize, int category) {
        return null;
    }

    @Override
    public Page<SubjectDTO> findSubjectBySubjectName(int pageNo, int pageSize, String subjectName) {
        return null;
    }

    @Override
    public Page<SubjectDTO> findSubjectNameAndFilter(int pageNo, int pageSize, String subjectName, int categoryId) {
        return null;
    }

    @Override
    public Page<SubjectDTO> sortSubjectBy(int pageNo, int pageSize, String sortBy, String order) {
        return null;
    }

    @Override
    public Page<SubjectDTO> filterAndSortSubject(int pageNo, int pageSize, int category, String sortBy, String order) {
        return null;
    }

    @Override
    public Page<SubjectDTO> searchAndSortSubject(int pageNo, int pageSize, String subjectName, String sortBy, String order) {
        return null;
    }

    @Override
    public Page<SubjectDTO> filterAndSearchAndSortSubject(int pageNo, int pageSize, int category, String subjectName, String sortBy, String order) {
        return null;
    }

    @Override
    public List<Subject> findByFeaturing(Boolean isFeatured) {
        List<Subject> featuringSubjects= iSubjectRepository.findAllByFeatured(isFeatured);
        return featuringSubjects;
    }

    @Override
    public List<Subject> listAll() {
        return iSubjectRepository.findAll();
    }

    @Override
    public Subject findByLesson(Integer id) {
        return iSubjectRepository.findByLessons_Id(id);
    }

    @Override
    public List<Subject> searchByCourseName(String s) {
        return null;
    }

    @Override
    public void save(Subject subject) {

    }


    @Override
    public Subject getById(int id) {
        return iSubjectRepository.findById(id);
    }

}
