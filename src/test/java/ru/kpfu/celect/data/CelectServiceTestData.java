package ru.kpfu.celect.data;

import ru.kpfu.celect.dto.AuthDto;
import ru.kpfu.celect.dto.InterviewDto;
import ru.kpfu.celect.model.Case;
import ru.kpfu.celect.model.Interview;
import ru.kpfu.celect.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Samat Khairutdinov on 14.12.16 16:22.
 * celect
 */
public class CelectServiceTestData {

    public static final String PHONE_NUMBER = "12121212";

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
                .id(1)
                .info("info")
                .build();
    }

    public static Interview getInterview2(){
        return new Interview.Builder()
                .id(2)
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
                .id(1)
                .info("info")
                .build();
    }

    public static InterviewDto getInterviewDto2(){
        return new InterviewDto.Builder()
                .id(2)
                .info("info")
                .build();
    }

    public static Case getCase(){
        return new Case.Builder()
                .fullInfo("full_info")
                .id(1)
                .mainInfo("main_info")
                .interview(getInterview())
                .build();
    }
    public static Case getCase2(){
        return new Case.Builder()
                .fullInfo("full_info")
                .id(1)
                .mainInfo("main_info")
                .interview(getInterview2())
                .build();
    }

    public static List<Case> getListCase(){
        List<Case> result =  new ArrayList<Case>();
        result.add(getCase());
        result.add(getCase2());
        return result;
    }


}
