package ru.kpfu.celect.converter;

import org.springframework.stereotype.Component;
import ru.kpfu.celect.dto.*;
import ru.kpfu.celect.model.CelectCase;
import ru.kpfu.celect.model.Question;
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
                .phone(user.getPhoneNumber())
                .build();
    }

    public User convert(String phone) {
        return new User.Builder()
                .phone(phone)
                .build();
    }

    public InterviewsDto interviewListToInterviewsDto(List<Question> questions) {
        List<InterviewDto> interviewDtos = new ArrayList<>();
        for (Question question : questions) {
            interviewDtos.add(convert(question));
        }
        return new InterviewsDto(interviewDtos);
    }

    public InterviewDto convert(Question question) {
        return new InterviewDto.Builder()
                .id(question.getId())
                .info(question.getInfo())
                .build();
    }

    public static InterviewCasesDto caseListToInterviewCasesDto(List<CelectCase> cases) {
        List<CaseDto> caseDtos = new ArrayList<>();
        for (CelectCase aCelectCase : cases) {
            caseDtos.add(convert(aCelectCase));
        }
        return new InterviewCasesDto(caseDtos);
    }

    public static CaseDto convert(CelectCase aCelectCase) {
        return aCelectCase != null ? new CaseDto.Builder()
                .id(aCelectCase.getId())
                .fullInfo(aCelectCase.getFullInfo())
                .mainInfo(aCelectCase.getMainInfo())
                .build() :
                new CaseDto();
    }

    public static CelectCase convert(CaseDto caseDto) {
        return caseDto != null ?
                new CelectCase()
                        .setId(caseDto.getId())
                        .setFullInfo(caseDto.getFullInfo())
                        .setMainInfo(caseDto.getMainInfo())
                        .setQuestion(new Question().setId(caseDto.getQuestionId())) :
                new CelectCase();
    }
}