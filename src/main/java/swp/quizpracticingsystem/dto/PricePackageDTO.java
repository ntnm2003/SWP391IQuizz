package swp.quizpracticingsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PricePackageDTO {
    private Integer idPrice;
    private Integer idSub;
    private String packageName;
    private Integer duration;
    private Integer price;
    private Integer salePrice;
    private Integer status;
}
