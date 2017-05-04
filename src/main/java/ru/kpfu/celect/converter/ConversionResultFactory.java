package ru.kpfu.celect.converter;

import org.springframework.stereotype.Component;
import ru.kpfu.celect.dto.*;
import ru.kpfu.celect.model.CelectCase;
import ru.kpfu.celect.model.Interview;
import ru.kpfu.celect.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Samat Khairutdinov on 28.10.16 14:22.
 * celect
 */
// TODO: 17.02.17 Refactor me!
@Component
public class ConversionResultFactory {
    public AuthDto convert(User user) {
        return new AuthDto.Builder()
                .phone(user.getPhoneNumber())
                .build();
    }

    public User convert(String phone) {
        return new User.Builder()
                .phone(phone)
                .build();
    }

    public InterviewsDto interviewListToInterviewsDto(List<Interview> interviews) {
        List<InterviewDto> interviewDtos = new ArrayList<>();
        for (Interview interview: interviews) {
            interviewDtos.add(convert(interview));
        }
        return new InterviewsDto(interviewDtos);
    }

    public InterviewDto convert(Interview interview) {
        return new InterviewDto.Builder()
                .id(interview.getId())
                .info(interview.getInfo())
                .build();
    }

    public InterviewCasesDto caseListToInterviewCasesDto(List<CelectCase> cases) {
        List<CaseDto> caseDtos = new ArrayList<>();
        for (CelectCase aCelectCase : cases) {
            caseDtos.add(convert(aCelectCase));
        }
        return new InterviewCasesDto(caseDtos);
    }

    public CaseDto convert(CelectCase aCelectCase) {
        return new CaseDto.Builder()
                .id(aCelectCase.getId())
                .fullInfo(aCelectCase.getFullInfo())
                .mainInfo(aCelectCase.getMainInfo())
                .build();
    }
}
