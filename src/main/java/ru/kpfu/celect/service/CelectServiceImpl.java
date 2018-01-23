package ru.kpfu.celect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.celect.converter.ConversionResultFactory;
import ru.kpfu.celect.dao.repository.*;
import ru.kpfu.celect.dto.*;
import ru.kpfu.celect.model.*;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by Samat Khairutdinov on 12.12.16 19:11.
 * celect
 */
@Service
public class CelectServiceImpl implements CelectService {

    @Autowired
    CaseRepository caseRepository;

    @Autowired
    AttempTestRepository attempTestRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ElectionsRepository electionsRepository;

    @Override
    public AuthDto login(String phone) {
        return null;
    }

    @Override
    public User registeration(User user) {
        return userRepository.save(user);
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

    @Override
    public AttempTestsDto getAttemptsTest() {
        return new AttempTestsDto().setAttempTests(StreamSupport.stream(attempTestRepository.findAll().spliterator(), false)
                .collect(Collectors.toList()));
    }

    @Override
    public AttempTestsDto getAttemptsTest(int userId) {
        return new AttempTestsDto().setAttempTests(attempTestRepository.findByUser(new User().setId(userId)));
    }

    @Override
    public AttempTest createAttempTest(int userId, int testId) {
        return attempTestRepository.save(new AttempTest());
    }

    @Override
    public QuestionsDto getQuestions(int testId) {
        return new QuestionsDto().
                setQuestion(
                        ConversionResultFactory.convertQuestions(
                                questionRepository.findByTest(new Test().setId(testId))));
    }

    @Override
    public QuestionDto getQuestion(int questionId) {
        return ConversionResultFactory.convert(questionRepository.findOne(questionId));
    }

    @Override
    public QuestionDto saveQuestion(Question question) {
        return ConversionResultFactory.convert(questionRepository.save(question));
    }

    @Override
    public ElectionsDto getUserElections() {
        return null;
    }

    @Override
    public ElectionsDto getAttemptElections(int attemptId) {
        return null;
    }

    @Override
    public Elections saveElections(Elections elections) {
        return electionsRepository.save(elections);
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
