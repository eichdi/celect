package ru.kpfu.celect.dto;

import java.util.List;

/**
 * Created by Samat Khairutdinov on 28.10.16 14:20.
 * celect
 */
public class InterviewCasesDto implements Dto {
    List<CaseDto> caseDtoList;

    public InterviewCasesDto() {}

    public InterviewCasesDto(List<CaseDto> caseDtoList){
        this.caseDtoList = caseDtoList;
    }

    public List<CaseDto> getCaseDtoList() {
        return caseDtoList;
    }
}
