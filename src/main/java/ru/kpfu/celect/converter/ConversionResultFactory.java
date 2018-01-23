package ru.kpfu.celect.converter;

import org.springframework.stereotype.Component;
import ru.kpfu.celect.dto.*;
import ru.kpfu.celect.model.CelectCase;
import ru.kpfu.celect.model.Question;
import ru.kpfu.celect.model.Test;
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


    public static QuestionDto convert(Question question) {
        return question != null ?
                new QuestionDto()
                        .setId(question.getId())
                        .setCaseDtoList(convertCelectCases(question.getCelectCase()))
                        .setInfo(question.getInfo())
                        .setTestDto(convertWihoutQuestions(question.getTest())) :
                new QuestionDto();
    }

    private static TestDto convertWihoutQuestions(Test test) {
        return test != null ?
                new TestDto()
                .setId(test.getId())
                .setDescription(test.getDescription()):
                new TestDto();
    }

    public static InterviewCasesDto caseListToInterviewCasesDto(List<CelectCase> cases) {
        return new InterviewCasesDto(convertCelectCases(cases));
    }

    public static List<CaseDto> convertCelectCases(List<CelectCase> celectCases) {
        List<CaseDto> caseDtos = new ArrayList<>(celectCases.size());
        for (CelectCase aCelectCase : celectCases) {
            caseDtos.add(convert(aCelectCase));
        }
        return caseDtos;
    }

    public static List<QuestionDto> convertQuestions(List<Question> questions) {
        List<QuestionDto> caseDtos = new ArrayList<>(questions.size());
        for (Question aCelectCase : questions) {
            caseDtos.add(convert(aCelectCase));
        }
        return caseDtos;
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