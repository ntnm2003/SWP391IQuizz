package swp391.quizpracticing.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserSubjectKeyDTO {
    private UserDTO user;
    private SubjectDTO subject;
    private PricepackageDTO pricePackage;
}

