package soul.dev.miniprojetjavaspring.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import soul.dev.miniprojetjavaspring.dtos.CaseReqDto;
import soul.dev.miniprojetjavaspring.dtos.CaseResDto;
import soul.dev.miniprojetjavaspring.entities.CaseEntity;

@Service
public class ImapperImpl implements Imapper {
    @Override
    public CaseResDto fromCaseToCaseResponse(CaseEntity aCaseEntity) {
        CaseResDto caseResDto = new CaseResDto();
        BeanUtils.copyProperties(aCaseEntity, caseResDto);
        return caseResDto;
    }

    @Override
    public CaseEntity fromCaseRequestDto(CaseReqDto caseReqDto) {
        CaseEntity caseEntity = new CaseEntity();
        BeanUtils.copyProperties(caseReqDto, caseEntity);
        return caseEntity;
    }


}
