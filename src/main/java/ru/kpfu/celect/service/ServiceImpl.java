package ru.kpfu.celect.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.kpfu.celect.converter.ConversionResultFactory;
import ru.kpfu.celect.dao.CaseDao;
import ru.kpfu.celect.dao.ElectionsDao;
import ru.kpfu.celect.dao.InterviewDao;
import ru.kpfu.celect.dao.UserDao;
import ru.kpfu.celect.dto.AuthDto;
import ru.kpfu.celect.dto.CaseDto;
import ru.kpfu.celect.dto.InterviewCasesDto;
import ru.kpfu.celect.dto.InterviewsDto;
import ru.kpfu.celect.model.Elections;

/**
 * Created by Samat Khairutdinov on 12.12.16 19:11.
 * celect
 */
public class ServiceImpl implements Service {
    @Autowired
    CaseDao caseDao;

    @Autowired
    ElectionsDao electionsDao;

    @Autowired
    InterviewDao interviewDao;

    @Autowired
    UserDao userDao;

    @Autowired
    ConversionResultFactory covert;



    @Override
    public AuthDto login(String phone) {
        return null;
    }

    @Override
    public AuthDto registeration(String phone) {
        return null;
    }

    @Override
    public InterviewsDto getInterviews() {
        return null;
    }

    @Override
    public InterviewCasesDto getCase(int interviewId) {
        return null;
    }

    @Override
    public CaseDto election(int interviewId, int caseId, String phone) {
        return null;
    }
}
