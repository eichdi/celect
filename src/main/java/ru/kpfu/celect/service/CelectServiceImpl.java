package ru.kpfu.celect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.celect.converter.ConversionResultFactory;
import ru.kpfu.celect.dao.CaseDao;
import ru.kpfu.celect.dao.ElectionsDao;
import ru.kpfu.celect.dao.InterviewDao;
import ru.kpfu.celect.dao.UserDao;
import ru.kpfu.celect.dto.AuthDto;
import ru.kpfu.celect.dto.CaseDto;
import ru.kpfu.celect.dto.InterviewCasesDto;
import ru.kpfu.celect.dto.InterviewsDto;
import ru.kpfu.celect.model.Case;
import ru.kpfu.celect.model.Interview;
import ru.kpfu.celect.model.User;

import java.util.List;

/**
 * Created by Samat Khairutdinov on 12.12.16 19:11.
 * celect
 */
@Service
public class CelectServiceImpl implements CelectService {
    @Autowired
    CaseDao caseDao;

    @Autowired
    ElectionsDao electionsDao;

    @Autowired
    InterviewDao interviewDao;

    @Autowired
    UserDao userDao;

    @Autowired
    ConversionResultFactory convert;



    @Override
    public AuthDto login(String phone) {
        User user = userDao.findByPhone(phone);
        AuthDto result = convert.convert(user);
        return result;
    }

    @Override
    public AuthDto registeration(String phone) {
        User user = convert.convert(phone);
        user = userDao.insert(user);
        return convert.convert(user);
    }

    @Override
    public InterviewsDto getInterviews() {
        List<Interview> interviews = interviewDao.findAll();
        return convert.interviewListToInterviewsDto(interviews);
    }

    @Override
    public InterviewCasesDto getCase(int interviewId) {
        List<Case> cases = caseDao.findByInterview(interviewId);
        return convert.caseListToInterviewCasesDto(cases);
    }

    @Override
    public CaseDto election(int interviewId, int caseId, String phone) {
        User user = userDao.findByPhone(phone);
        electionsDao.insert(interviewId, caseId, user.getId());
        Case aCase = caseDao.findById(caseId);
        return convert.convert(aCase);
    }
}
