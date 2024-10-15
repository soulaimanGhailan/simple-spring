package soul.dev.miniprojetjavaspring.mappers;

import soul.dev.miniprojetjavaspring.dtos.CaseDto;
import soul.dev.miniprojetjavaspring.entities.Case;

public interface Imapper {
    CaseDto fromCase(Case aCase) ;
    Case fromCaseDto(CaseDto aCaseDto) ;
}
