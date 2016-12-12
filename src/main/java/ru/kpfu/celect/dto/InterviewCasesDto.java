package ru.kpfu.celect.dto;

import java.util.List;

/**
 * Created by Samat Khairutdinov on 28.10.16 14:20.
 * celect
 */
public class InterviewCasesDto {
    List<CaseDto> caseDtoList;

    public InterviewCasesDto() {}

    public InterviewCasesDto(List<CaseDto> recipientDtoList){
        this.caseDtoList = recipientDtoList;
    }

    public List<CaseDto> getRecipientDtoList() {
        return caseDtoList;
    }
}
