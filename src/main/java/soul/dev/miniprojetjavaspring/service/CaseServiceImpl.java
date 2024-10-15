package soul.dev.miniprojetjavaspring.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import soul.dev.miniprojetjavaspring.dtos.CaseDto;
import soul.dev.miniprojetjavaspring.entities.Case;
import soul.dev.miniprojetjavaspring.exception.CaseNotFoundException;
import soul.dev.miniprojetjavaspring.mappers.Imapper;
import soul.dev.miniprojetjavaspring.repository.CaseRepo;

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
    public CaseDto updateCase(CaseDto caseDto) throws CaseNotFoundException {
        Case aCase = caseRepo.findById(caseDto.getId()).orElseThrow(() -> new CaseNotFoundException("Case of id " + caseDto.getId() + " not found"));
        BeanUtils.copyProperties(caseDto , aCase);
        Case updatedCase = caseRepo.save(aCase);
        return imapper.fromCase(updatedCase);
    }

    @Override
    public CaseDto addCase(CaseDto caseDto) {
        Case aCase = imapper.fromCaseDto(caseDto) ;
        Case savedCase = caseRepo.save(aCase);
        return imapper.fromCase(savedCase);
    }

    @Override
    public CaseDto getCase(long id) throws CaseNotFoundException {
        Case aCase = caseRepo.findById(id).orElseThrow(() -> new CaseNotFoundException("Case of id " + id + " not found"));
        return imapper.fromCase(aCase);
    }

    @Override
    public CaseDto deleteCase(long id) throws CaseNotFoundException {
        Case aCase = caseRepo.findById(id).orElseThrow(() -> new CaseNotFoundException("Case of id " + id + " not found"));
        caseRepo.deleteById(id);
        return imapper.fromCase(aCase);
    }
}
