package ru.kpfu.celect.data;

import ru.kpfu.celect.dto.*;
import ru.kpfu.celect.model.CelectCase;
import ru.kpfu.celect.model.Interview;
import ru.kpfu.celect.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Samat Khairutdinov on 14.12.16 16:22.
 * celect
 */
public class TestData {

    public static final String PHONE_NUMBER = "12121212";
    public static final int INTERVIEW_ID = 1;
    public static final int CASE_ID = 1;

    public static AuthDto getAuthDto(){
        return new AuthDto.Builder()
                .phone(PHONE_NUMBER)
                .build();
    }

    public static User getUser(){
        return new User.Builder()
                .id(1)
                .phone(PHONE_NUMBER)
                .build();
    }

    public static User insertUser(){
        return new User.Builder()
                .id(0)
                .phone(PHONE_NUMBER)
                .build();
    }

    public static Interview getInterview(){
        return new Interview.Builder()
                .id(INTERVIEW_ID)
                .info("info")
                .build();
    }

    public static Interview getInterview2(){
        return new Interview.Builder()
                .id(INTERVIEW_ID+1)
                .info("info")
                .build();
    }

    public static List<Interview> getListInterview(){
        List<Interview> result =  new ArrayList<Interview>();
        result.add(getInterview());
        result.add(getInterview2());
        return result;
    }

    public static InterviewDto getInterviewDto(){
        return new InterviewDto.Builder()
                .id(INTERVIEW_ID)
                .info("info")
                .build();
    }

    public static InterviewDto getInterviewDto2(){
        return new InterviewDto.Builder()
                .id(INTERVIEW_ID+1)
                .info("info")
                .build();
    }

    public static CelectCase getCase(){
        return new CelectCase.Builder()
                .fullInfo("full_info")
                .id(CASE_ID)
                .mainInfo("main_info")
                .interview(getInterview())
                .build();
    }
    public static CelectCase getCase2(){
        return new CelectCase.Builder()
                .fullInfo("full_info")
                .id(CASE_ID+1)
                .mainInfo("main_info")
                .interview(getInterview2())
                .build();
    }

    public static List<CelectCase> getListCase(){
        List<CelectCase> result =  new ArrayList<CelectCase>();
        result.add(getCase());
        result.add(getCase2());
        return result;
    }

    public static CaseDto getCaseDto(){
        return new CaseDto.Builder()
                .fullInfo("full_info")
                .id(CASE_ID)
                .mainInfo("main_info")
                .build();
    }

    public static CaseDto getCaseDto2(){
        return new CaseDto.Builder()
                .fullInfo("full_info")
                .id(CASE_ID+1)
                .mainInfo("main_info")
                .build();
    }

    public static List<CaseDto> getListCaseDto(){
        List<CaseDto> result =  new ArrayList<>();
        result.add(getCaseDto());
        result.add(getCaseDto2());
        return result;
    }

    public static InterviewCasesDto getInterviewCasesDto(){
        return new InterviewCasesDto(getListCaseDto());
    }

    public static List<InterviewDto> getInterviewDtos(){
        List<InterviewDto> result =  new ArrayList<>();
        result.add(getInterviewDto());
        result.add(getInterviewDto2());
        return result;
    }

    public static InterviewsDto getInterviewsDto(){
        return new InterviewsDto(getInterviewDtos());
    }


}
