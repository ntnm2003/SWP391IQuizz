/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp391.quizpracticing.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Mosena
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserSubjectKeyDTO {
    private UserDTO user;
    private SubjectDTO subject;
    private PricepackageDTO pricePackage;
}
