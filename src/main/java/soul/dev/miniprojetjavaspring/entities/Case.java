package soul.dev.miniprojetjavaspring.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor @Builder
public class Case {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private String title ;
    private Date creationDate;
    private Date lastUpdateDate;
    private String description ;

}
