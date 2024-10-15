package soul.dev.miniprojetjavaspring.mappers;

import soul.dev.miniprojetjavaspring.dtos.CaseReqDto;
import soul.dev.miniprojetjavaspring.dtos.CaseResDto;
import soul.dev.miniprojetjavaspring.entities.CaseEntity;

public interface Imapper {
    CaseResDto fromCaseToCaseResponse(CaseEntity aCaseEntity) ;
    CaseEntity fromCaseRequestDto(CaseReqDto caseReqDto) ;
}
