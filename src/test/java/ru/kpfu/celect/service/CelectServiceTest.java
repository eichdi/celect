package ru.kpfu.celect.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.kpfu.celect.converter.ConversionResultFactory;
import ru.kpfu.celect.dao.CaseDao;
import ru.kpfu.celect.dao.ElectionsDao;
import ru.kpfu.celect.dao.InterviewDao;
import ru.kpfu.celect.dao.UserDao;
import ru.kpfu.celect.data.TestData;
import ru.kpfu.celect.model.CelectCase;
import ru.kpfu.celect.model.Interview;
import ru.kpfu.celect.model.User;

import java.util.List;

import static ru.kpfu.celect.data.TestData.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


/**
 * Created by Samat Khairutdinov on 14.12.16 16:15.
 * celect
 */
public class CelectServiceTest {

    @InjectMocks
    private CelectService celectService = new CelectServiceImpl();

    @Mock
    CaseDao caseDao;

    @Mock
    ElectionsDao electionsDao;

    @Mock
    InterviewDao interviewDao;

    @Mock
    UserDao userDao;

    @Mock
    ConversionResultFactory convert;

    public static final int INTERVIEW_ID = 1;
    public static final int CASE_ID = 1;

    User user = getUser();
    CelectCase aCelectCase = TestData.getCase();
    List<Interview> interviewList = getListInterview();
    List<CelectCase> caseList = getListCase();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);


        //Мокирование Dao
        when(userDao.findByPhone(   PHONE_NUMBER))  .thenReturn(user);
        when(userDao.findeUserById( user.getId()))  .thenReturn(user);
        when(userDao.insert(        user))          .thenReturn(user);
        when(interviewDao.findAll())                .thenReturn(interviewList);
        when(caseDao.findByInterview(INTERVIEW_ID)) .thenReturn(caseList);
        when(caseDao.findById(CASE_ID))             .thenReturn(aCelectCase);

        //Устновка вызова реальных методов в конвертере
        doCallRealMethod().when(convert).convert((User)         anyObject());
        doCallRealMethod().when(convert).convert((CelectCase)         anyObject());
        doCallRealMethod().when(convert).convert((Interview)    anyObject());
        doCallRealMethod().when(convert).convert(               anyString());
        doCallRealMethod().when(convert).caseListToInterviewCasesDto(anyListOf(CelectCase.class));
        doCallRealMethod().when(convert).interviewListToInterviewsDto(anyListOf(Interview.class));

    }

    @Test
    public void login(){
        assertEquals(celectService.login(getUser().getPhoneNumber()), getAuthDto());
    }

    @Test
    public void registration(){
        doReturn(user).when(convert).convert(PHONE_NUMBER);
        assertEquals(celectService.registeration(PHONE_NUMBER), getAuthDto());
    }

    @Test
    public void getInterviews(){
        assertEquals(celectService.getInterviews(), convert.interviewListToInterviewsDto(interviewList));
    }

    @Test
    public void getCase(){
        assertEquals(celectService.getCase(INTERVIEW_ID), convert.caseListToInterviewCasesDto(caseList));
    }

    @Test
    public void election(){
        assertEquals(celectService.election(INTERVIEW_ID, CASE_ID, PHONE_NUMBER), convert.convert(aCelectCase));
    }

}
