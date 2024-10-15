package soul.dev.miniprojetjavaspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soul.dev.miniprojetjavaspring.entities.CaseEntity;

public interface CaseRepo extends JpaRepository<CaseEntity, Long> {
}
