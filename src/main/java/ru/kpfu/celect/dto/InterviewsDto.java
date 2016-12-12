package ru.kpfu.celect.dto;

import java.util.List;

/**
 * Created by Samat Khairutdinov on 28.10.16 14:18.
 * celect
 */
public class InterviewsDto {
    List<InterviewDto> interviewDtoist;

    public InterviewsDto() {}

    public InterviewsDto(List<InterviewDto> recipientDtoList){
        this.interviewDtoist = recipientDtoList;
    }

    public List<InterviewDto> getRecipientDtoList() {
        return interviewDtoist;
    }
}
