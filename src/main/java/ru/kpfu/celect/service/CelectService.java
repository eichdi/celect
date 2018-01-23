package ru.kpfu.celect.service;

import ru.kpfu.celect.dto.*;
import ru.kpfu.celect.model.AttempTest;
import ru.kpfu.celect.model.Elections;
import ru.kpfu.celect.model.Question;
import ru.kpfu.celect.model.User;

/**
 * Created by Samat Khairutdinov on 12.12.16 19:11.
 * celect
 */
public interface CelectService {
    AuthDto login(String phone);

    User registeration(User phone);

    InterviewsDto getInterviews();

    InterviewCasesDto getCases(int questionId);

    CaseDto getCase(int caseId);

    CaseDto saveCase(CaseDto caseDto);

    AttempTestsDto getAttemptsTest();

    AttempTestsDto getAttemptsTest(int userId);

    AttempTest createAttempTest(int userId, int testId);

    QuestionsDto getQuestions(int testId);

    QuestionDto getQuestion(int questionId);

    QuestionDto saveQuestion(Question question);

    ElectionsDto getUserElections();

    ElectionsDto getAttemptElections(int attemptId);

    Elections saveElections(Elections elections);
}
