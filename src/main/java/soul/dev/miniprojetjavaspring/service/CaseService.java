package soul.dev.miniprojetjavaspring.service;

import soul.dev.miniprojetjavaspring.dtos.CaseDto;
import soul.dev.miniprojetjavaspring.exception.CaseNotFoundException;

public interface CaseService  {
     CaseDto updateCase(CaseDto caseDto) throws CaseNotFoundException; ;
     CaseDto addCase(CaseDto caseDto) ;
     CaseDto getCase(long id) throws CaseNotFoundException;
     CaseDto deleteCase(long id) throws CaseNotFoundException;
}
