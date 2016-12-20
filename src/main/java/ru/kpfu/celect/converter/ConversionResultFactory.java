package ru.kpfu.celect.converter;

import org.springframework.stereotype.Component;
import ru.kpfu.celect.dto.*;
import ru.kpfu.celect.model.Case;
import ru.kpfu.celect.model.Interview;
import ru.kpfu.celect.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Samat Khairutdinov on 28.10.16 14:22.
 * celect
 */
@Component
public class ConversionResultFactory {
    public AuthDto convert(User user) {
        return new AuthDto.Builder()
                .phone(user.getPhone_number())
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

    public InterviewCasesDto caseListToInterviewCasesDto(List<Case> cases) {
        List<CaseDto> caseDtos = new ArrayList<>();
        for (Case aCase: cases) {
            caseDtos.add(convert(aCase));
        }
        return new InterviewCasesDto(caseDtos);
    }

    public CaseDto convert(Case aCase) {
        return new CaseDto.Builder()
                .id(aCase.getId())
                .fullInfo(aCase.getFullInfo())
                .mainInfo(aCase.getMainInfo())
                .build();
    }
}
