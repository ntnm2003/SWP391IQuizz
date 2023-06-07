/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package swp391.quizpracticing.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import swp391.quizpracticing.model.Settings;

/**
 *
 * @author Mosena
 */
@Repository
public interface ISettingsRepository extends JpaRepository<Settings,Integer>, 
        JpaSpecificationExecutor<Settings> {
    @Override
    public Page<Settings> findAll(Specification spec,Pageable pageable);
    
    @Override
    public Settings save(Settings s);
    
    @Modifying
    @Query("UPDATE Settings s SET s.type = :type WHERE s.id = :settingsId")
    public void settingsUpdateType(@Param("settingsId") Integer settingsId,
            @Param("type") String type);
    
    @Modifying
    @Query("UPDATE Settings s SET s.value = :value WHERE s.id = :settingsId")
    public void settingsUpdateValue(@Param("settingsId") Integer settingsId,
            @Param("value") String value);
    
    @Modifying
    @Query("UPDATE Settings s SET s.order = :order WHERE s.id = :settingsId")
    public void settingsUpdateOrder(@Param("settingsId") Integer settingsId,
            @Param("order") Integer order);
    
    @Modifying
    @Query("UPDATE Settings s SET s.type = :status WHERE s.id = :settingsId")
    public void settingsUpdateStatus(@Param("settingsId") Integer settingsId,
            @Param("status") Boolean status);
}
