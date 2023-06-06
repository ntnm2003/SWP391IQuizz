/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp391.quizpracticing.serviceimple;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import swp391.quizpracticing.dto.SettingsDTO;
import swp391.quizpracticing.model.Settings;
import swp391.quizpracticing.repository.ISettingsRepository;
import swp391.quizpracticing.service.ISettingsService;

/**
 *
 * @author Mosena
 */
@Service
public class SettingsService implements ISettingsService {
    
    @Autowired
    private ISettingsRepository settingsRepository;
    
    @Autowired
    private ModelMapper modelMapper;
    
    private SettingsDTO convertEntityToDTO(Settings entity){
        return modelMapper.map(entity,SettingsDTO.class);
    }

    @Override
    public List<SettingsDTO> getSettings(int pageNo, int pageSize, 
            String type, Boolean status, String sortBy,String order) {
        Pageable page;
        if(order.equals("asc")){
            page = PageRequest.of(pageNo - 1, pageSize, 
                    Sort.by(sortBy).ascending());
        }
        else{
            page = PageRequest.of(pageNo - 1, pageSize, 
                    Sort.by(sortBy).descending());
        }
        Specification<Settings> specification=null;
        if(type!=null && status==null){
            specification=(Root<Settings> root, CriteriaQuery<?> query,
                    CriteriaBuilder criteriaBuilder) 
                    -> criteriaBuilder.equal(root.get("type"), 
                    type);
        }
        else if(type==null && status!=null){
            specification=(Root<Settings> root, CriteriaQuery<?> query,
                    CriteriaBuilder criteriaBuilder) 
                    -> criteriaBuilder.equal(root.get("status"), 
                    status);
        }
        return settingsRepository.findAll(specification, page)
                .stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SettingsDTO addSettings(String type, String value, 
            Integer order, Boolean status) {
        Settings s=new Settings();
        switch(type){
            case "User Roles" ->{
                
            }
            case "Post Categories" ->{
                
            }
            case "Subject Categories" ->{
                
            }
            case "Test Types" ->{
                
            }
            case "Question Levels" ->{
                
            }
            case "Lesson Types" ->{
                
            }
            case "Subject Dimension" ->{
                
            }
        }
        return convertEntityToDTO(settingsRepository.save(s));
    }
}
