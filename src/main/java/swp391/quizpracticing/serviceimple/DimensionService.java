/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp391.quizpracticing.serviceimple;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import swp391.quizpracticing.dto.DimensionDTO;
import swp391.quizpracticing.model.Dimension;
import swp391.quizpracticing.repository.IDimensionRepository;
import swp391.quizpracticing.service.IDimensionService;

/**
 *
 * @author Mosena
 */
@Service
public class DimensionService implements IDimensionService {
    @Autowired
    private ModelMapper modelMapper;

    private DimensionDTO convertEntityToDTO(Dimension entity){
        return modelMapper.map(entity,DimensionDTO.class);
    }

    @Autowired
    private IDimensionRepository iDimensionRepository;

    @Override
    public List<DimensionDTO> getAllDimension() {
        List<Dimension> dimension = iDimensionRepository.findAll();
        return dimension
                .stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Dimension getDimensionById(Integer id) {
        return iDimensionRepository.findById(id).get();

    }

}

