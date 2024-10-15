package soul.dev.miniprojetjavaspring.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@AllArgsConstructor @NoArgsConstructor
public class CaseDto {
    private long id ;
    private String title ;
    private Date creationDate;
    private Date lastUpdateDate;
    private String description ;
}
