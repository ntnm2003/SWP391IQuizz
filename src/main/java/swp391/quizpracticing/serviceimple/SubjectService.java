/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp391.quizpracticing.serviceimple;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
        return iSubjectRepository.findAllByFeatured(isFeatured);
    }

    @Override
    public List<Subject> listAll() {
        return iSubjectRepository.findAll();
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

    @Override
    public List<Subject> findSubjectsWithSorting(String field) {
        return iSubjectRepository.findAll(Sort.by(Sort.Direction.ASC, field));
    }

    @Override
    public Page<Subject> findSubjectsWithPagination(int pageNum, int itemPerPage) {
        return iSubjectRepository.findAll(PageRequest.of(pageNum, itemPerPage));
    }

    @Override
    public Page<Subject> findSubjectsWithPaginationByExpertId(Integer id, int pageNum, int itemPerPage) {
        Pageable pageRequest = PageRequest.of(pageNum, itemPerPage);
        return iSubjectRepository.findByOwnerId(id, pageRequest);
    }

    @Override
    public Page<Subject> findSubjectsWithPaginationByExpertIdAndByName(Integer id, String searchTerm, int pageNum, int itemPerPage) {
        return iSubjectRepository.findByOwnerIdAndName(id, searchTerm, PageRequest.of(pageNum, itemPerPage));
    }

    @Override
    public Page<Subject> findSubjectsWithPaginationByExpertIdAndByStatus(Integer id, Integer status, int pageNum, int itemPerPage) {
        return iSubjectRepository.findByOwnerIdAndStatus(id, status, PageRequest.of(pageNum,itemPerPage));
    }

    @Override
    public Page<Subject> findSubjectsWithPaginationAndSorting(int pageNum, int itemPerPage, String field) {
        return iSubjectRepository.findAll(PageRequest.of(pageNum, itemPerPage).withSort(Sort.by(Sort.Direction.ASC, field)));
    }

    @Override
    public Page<Subject> searchForSubjectsByName(int pageNum, int itemPerPage, String searchTerm) {
        return iSubjectRepository.findByBriefInfoContainingIgnoreCase(searchTerm, PageRequest.of(pageNum, itemPerPage));
    }

    @Override
    public Page<Subject> findSubjectsByStatus(Boolean status, int pageNum, int itemPerPage) {
        return iSubjectRepository.findByStatus(status, PageRequest.of(pageNum, itemPerPage));
    }


}
