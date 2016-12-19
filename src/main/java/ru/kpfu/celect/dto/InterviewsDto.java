package ru.kpfu.celect.dto;

import java.util.List;
import java.util.Objects;

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


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InterviewsDto that = (InterviewsDto) o;
        return Objects.equals(interviewDtoList, that.interviewDtoList);
    }
}
