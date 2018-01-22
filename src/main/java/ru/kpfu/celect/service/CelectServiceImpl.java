package ru.kpfu.celect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.kpfu.celect.converter.ConversionResultFactory;
import ru.kpfu.celect.dao.CaseDao;
import ru.kpfu.celect.dao.ElectionsDao;
import ru.kpfu.celect.dao.InterviewDao;
import ru.kpfu.celect.dao.UserDao;
import ru.kpfu.celect.dao.repository.CaseRepository;
import ru.kpfu.celect.dto.AuthDto;
import ru.kpfu.celect.dto.CaseDto;
import ru.kpfu.celect.dto.InterviewCasesDto;
import ru.kpfu.celect.dto.InterviewsDto;
import ru.kpfu.celect.model.CelectCase;
import ru.kpfu.celect.model.Question;
import ru.kpfu.celect.model.User;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Samat Khairutdinov on 12.12.16 19:11.
 * celect
 */
@Service
public class CelectServiceImpl implements CelectService {

    @Autowired
    CaseRepository caseRepository;

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
    public InterviewCasesDto getCases(int questionId) {
        return ConversionResultFactory.caseListToInterviewCasesDto(caseRepository.findByQuestion(new Question().setId(questionId)));
    }

    @Override
    public CaseDto getCase(int caseId) {
        return ConversionResultFactory.convert(caseRepository.findOne(caseId));
    }

    @Override
    public CaseDto saveCase(CaseDto caseDto) {
        return ConversionResultFactory.convert(
                caseRepository.save(ConversionResultFactory.convert(caseDto)));
    }

//    @Autowired
//    CaseDao caseDao;
//
//    @Autowired
//    ElectionsDao electionsDao;
//
//    @Autowired
//    InterviewDao interviewDao;
//
//    @Autowired
//    UserDao userDao;

//    @Autowired
//    ConversionResultFactory convert;
//
//
//
//    @Override
//    public AuthDto login(String phone) {
//        User user = userDao.findByPhone(phone);
//        AuthDto result = convert.convert(user);
//        return result;
//    }
//
//    @Override
//    public AuthDto registeration(String phone) {
//        User user = convert.convert(phone);
//        user = userDao.insert(user);
//        return convert.convert(user);
//    }
//
//    @Override
//    public InterviewsDto getInterviews() {
//        List<Question> questions = interviewDao.findAll();
//        return convert.interviewListToInterviewsDto(questions);
//    }
//
//    @Override
//    public InterviewCasesDto getCases(int interviewId) {
//        List<CelectCase> cases = caseDao.findByInterview(interviewId);
//        return convert.caseListToInterviewCasesDto(cases);
//    }
//
//    @Override
//    public CaseDto getCase(int interviewId, int caseId, String phone) {
//        User user = userDao.findByPhone(phone);
//        try{
//            electionsDao.insert(interviewId, caseId, user.getId());
//        }
//        finally {
//            CelectCase aCelectCase = caseDao.findById(caseId);
//            return convert.convert(aCelectCase);
//        }
//    }
}
