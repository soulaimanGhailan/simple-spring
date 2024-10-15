package soul.dev.miniprojetjavaspring.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor @NoArgsConstructor
public class CaseResDto {
    private long id ;
    private String title ;
    private Date creationDate;
    private Date lastUpdateDate;
    private String description ;
}
