package ru.kpfu.celect.service;

import ru.kpfu.celect.dto.AuthDto;
import ru.kpfu.celect.dto.CaseDto;
import ru.kpfu.celect.dto.InterviewCasesDto;
import ru.kpfu.celect.dto.InterviewsDto;

/**
 * Created by Samat Khairutdinov on 12.12.16 19:11.
 * celect
 */
public interface Service {
    AuthDto login(String phone);
    AuthDto registeration(String phone);
    InterviewsDto getInterviews();
    InterviewCasesDto getCase(int interviewId);
    CaseDto election(int interviewId, int caseId, String phone);
}
