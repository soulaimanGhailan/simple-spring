package soul.dev.miniprojetjavaspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soul.dev.miniprojetjavaspring.entities.Case;

public interface CaseRepo extends JpaRepository<Case, Long> {
}
