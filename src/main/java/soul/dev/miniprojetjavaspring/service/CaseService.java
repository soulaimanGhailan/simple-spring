package soul.dev.miniprojetjavaspring.service;

import soul.dev.miniprojetjavaspring.dtos.CaseReqDto;
import soul.dev.miniprojetjavaspring.dtos.CaseResDto;
import soul.dev.miniprojetjavaspring.exception.CaseNotFoundException;

public interface CaseService  {
     CaseResDto updateCase(CaseReqDto caseReqDto , long id) throws CaseNotFoundException; ;
     CaseResDto addCase(CaseReqDto caseReqDto) ;
     CaseResDto getCase(long id) throws CaseNotFoundException;
     CaseResDto deleteCase(long id) throws CaseNotFoundException;
}
