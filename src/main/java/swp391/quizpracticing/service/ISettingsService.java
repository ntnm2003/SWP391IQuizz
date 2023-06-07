/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package swp391.quizpracticing.service;

import org.springframework.data.domain.Page;
import swp391.quizpracticing.dto.SettingsDTO;

/**
 *
 * @author Mosena
 */
public interface ISettingsService {
    public Page<SettingsDTO> getSettings(int pageNo, int pageSize, 
            String type, Boolean status, String sortBy, String order);
    public void addSetting(String type, Integer order, Object o);
    public Page<SettingsDTO> searchSettings(int pageNo, int pageSize,
            String type,Boolean status, 
            String sortBy, String order, String value);
}
