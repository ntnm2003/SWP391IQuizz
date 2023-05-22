/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp.quizpracticingsystem.serviceImple;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swp.quizpracticingsystem.dto.PricePackageDTO;
import swp.quizpracticingsystem.model.PricePackage;
import swp.quizpracticingsystem.repository.IPricePackageRepository;
import swp.quizpracticingsystem.service.IPricePackageService;

/**
 *
 * @author Mosena
 */
@Service
@Transactional
public class PricePackageService implements IPricePackageService {
    private IPricePackageRepository pricePackageRepository;
    @Autowired
    private ModelMapper modelmapper;
    
    @Override
    public List<PricePackageDTO> findAllPricePackage(int subjectId) {
        return pricePackageRepository.findAll(subjectId)
                .stream()
                .map(this::convertEntitytoDTO)
                .collect(Collectors.toList());
    }
    
    public PricePackageDTO convertEntitytoDTO(PricePackage entity){
        return modelmapper.map(entity, PricePackageDTO.class);
    }
}
