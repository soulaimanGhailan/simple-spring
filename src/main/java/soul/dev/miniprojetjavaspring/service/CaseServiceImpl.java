package soul.dev.miniprojetjavaspring.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import soul.dev.miniprojetjavaspring.dtos.CaseReqDto;
import soul.dev.miniprojetjavaspring.dtos.CaseResDto;
import soul.dev.miniprojetjavaspring.entities.CaseEntity;
import soul.dev.miniprojetjavaspring.exception.CaseNotFoundException;
import soul.dev.miniprojetjavaspring.mappers.Imapper;
import soul.dev.miniprojetjavaspring.repository.CaseRepo;

import java.util.Date;

@Service
@Transactional
public class CaseServiceImpl implements CaseService {

    private CaseRepo caseRepo ;
    private Imapper imapper ;

    public CaseServiceImpl(CaseRepo caseRepo, Imapper imapper) {
        this.caseRepo = caseRepo;
        this.imapper = imapper;
    }

    @Override
    public CaseResDto updateCase(CaseReqDto caseReqDto , long id) throws CaseNotFoundException {
        CaseEntity caseEntity = caseRepo.findById(id).orElseThrow(() -> new CaseNotFoundException("Case of id " + id + " not found"));
        caseEntity.setTitle(caseReqDto.getTitle());
        caseEntity.setDescription(caseReqDto.getDescription()); ;
        caseEntity.setLastUpdateDate(new Date());
        CaseEntity updatedCaseEntity = caseRepo.save(caseEntity);
        return imapper.fromCaseToCaseResponse(updatedCaseEntity);
    }

    @Override
    public CaseResDto addCase(CaseReqDto caseReqDto) {
        CaseEntity caseEntity = imapper.fromCaseRequestDto(caseReqDto) ;
        Date date = new Date();
        caseEntity.setCreationDate(date);
        caseEntity.setLastUpdateDate(date);
        CaseEntity savedCaseEntity = caseRepo.save(caseEntity);
        return imapper.fromCaseToCaseResponse(savedCaseEntity);
    }

    @Override
    public CaseResDto getCase(long id) throws CaseNotFoundException {
        CaseEntity aCaseEntity = caseRepo.findById(id).orElseThrow(() -> new CaseNotFoundException("Case of id " + id + " not found"));
        return imapper.fromCaseToCaseResponse(aCaseEntity);
    }

    @Override
    public CaseResDto deleteCase(long id) throws CaseNotFoundException {
        CaseEntity aCaseEntity = caseRepo.findById(id).orElseThrow(() -> new CaseNotFoundException("Case of id " + id + " not found"));
        caseRepo.deleteById(id);
        return imapper.fromCaseToCaseResponse(aCaseEntity);
    }
}
