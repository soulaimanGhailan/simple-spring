package soul.dev.miniprojetjavaspring.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CaseReqDto {
    private String title ;
    private String description ;
}
