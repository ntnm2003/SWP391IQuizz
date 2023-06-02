package swp391.quizpracticing.dto;

import java.sql.Timestamp;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import swp.quizpracticingsystem.dto.PricePackageDTO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDTO {
    private Integer id;
    private List<PricePackageDTO> pricePackage;
    private String title;
    private String briefInfo;
    private String description;
    private String thumbnail;
    private DimensionDTO dimension;
    private Boolean status;
    private Timestamp createdTime;
    private UserDTO owner;
    private List<LessonDTO>lessons;
    private List<UserSubjectDTO>userSubjects;
    private List<SubcategoryDTO>subCategories;
}
