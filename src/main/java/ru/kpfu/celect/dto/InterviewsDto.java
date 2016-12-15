package ru.kpfu.celect.dto;

import java.util.List;

/**
 * Created by Samat Khairutdinov on 28.10.16 14:18.
 * celect
 */
public class InterviewsDto implements Dto {
    List<InterviewDto> interviewDtoList;

    public InterviewsDto() {}

    public InterviewsDto(List<InterviewDto> interviewDtoList){
        this.interviewDtoList = interviewDtoList;
    }

    public List<InterviewDto> getInterviewDtoList() {
        return interviewDtoList;
    }


}
