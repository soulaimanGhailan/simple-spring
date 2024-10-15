package soul.dev.miniprojetjavaspring.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import soul.dev.miniprojetjavaspring.dtos.CaseDto;
import soul.dev.miniprojetjavaspring.exception.CaseNotFoundException;
import soul.dev.miniprojetjavaspring.service.CaseService;

@RestController
@RequestMapping("/cases")
@Slf4j
public class CaseRestController {

    private CaseService caseService;

    public CaseRestController(CaseService caseService) {
        this.caseService = caseService;
    }

    @GetMapping("{id}")
    public ResponseEntity<CaseDto> getCase(@PathVariable int id) {
        try {
            CaseDto caseDto = caseService.getCase(id);
            return ResponseEntity.ok(caseDto) ;
        } catch (CaseNotFoundException e) {
            log.error("Case with id {} not found", id);
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity<CaseDto> getCase(@RequestBody CaseDto caseDto) {
        CaseDto caseDto1 = caseService.addCase(caseDto);
        return ResponseEntity.ok(caseDto) ;
    }
    /** id est passe via caseDto **/
    @PutMapping
    public ResponseEntity<CaseDto> updateCase(@RequestBody CaseDto caseDto) {
        try {
            CaseDto caseDto1 = caseService.updateCase(caseDto);
            return ResponseEntity.ok(caseDto1) ;
        } catch (CaseNotFoundException e) {
            log.error("Case with id {} not found", caseDto.getId());
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<CaseDto> updateCase(@PathVariable long id) {
        try {
            CaseDto caseDto1 = caseService.deleteCase(id);
            return ResponseEntity.ok(caseDto1) ;
        } catch (CaseNotFoundException e) {
            log.error("Case with id {} not found", id);
            return ResponseEntity.internalServerError().build();
        }
    }
}
