package soul.dev.miniprojetjavaspring.mappers;

import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import soul.dev.miniprojetjavaspring.dtos.CaseDto;
import soul.dev.miniprojetjavaspring.entities.Case;

@Service
public class ImapperImpl implements Imapper {
    @Override
    public CaseDto fromCase(Case aCase) {
        CaseDto caseDto = new CaseDto();
        BeanUtils.copyProperties(aCase, caseDto);
        return caseDto;
    }

    @Override
    public Case fromCaseDto(CaseDto caseDto) {
        Case aCase = new Case();
        BeanUtils.copyProperties(caseDto, aCase);
        return aCase;
    }
}
