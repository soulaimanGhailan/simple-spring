package soul.dev.miniprojetjavaspring.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import soul.dev.miniprojetjavaspring.dtos.CaseReqDto;
import soul.dev.miniprojetjavaspring.dtos.CaseResDto;
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
    public ResponseEntity<CaseResDto> getCase(@PathVariable int id) {
        try {
            CaseResDto caseResDto = caseService.getCase(id);
            return ResponseEntity.ok(caseResDto) ;
        } catch (CaseNotFoundException e) {
            log.error("Case with id {} not found", id);
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity<CaseResDto> getCase(@RequestBody CaseReqDto caseReqDto) {
        CaseResDto caseResDto1 = caseService.addCase(caseReqDto);
        return ResponseEntity.ok(caseResDto1) ;
    }

    @PutMapping("{id}")
    public ResponseEntity<CaseResDto> updateCase(@RequestBody CaseReqDto caseReqDto , @PathVariable int id) {
        try {
            CaseResDto caseResDto1 = caseService.updateCase(caseReqDto , id);
            return ResponseEntity.ok(caseResDto1) ;
        } catch (CaseNotFoundException e) {
            log.error("Case with id {} not found", id);
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<CaseResDto> updateCase(@PathVariable long id) {
        try {
            CaseResDto caseResDto1 = caseService.deleteCase(id);
            return ResponseEntity.ok(caseResDto1) ;
        } catch (CaseNotFoundException e) {
            log.error("Case with id {} not found", id);
            return ResponseEntity.internalServerError().build();
        }
    }
}
