package ru.kpfu.celect.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import ru.kpfu.celect.converter.ConversionResultFactory;
import ru.kpfu.celect.dao.CaseDao;
import ru.kpfu.celect.dao.ElectionsDao;
import ru.kpfu.celect.dao.InterviewDao;
import ru.kpfu.celect.dao.UserDao;
import ru.kpfu.celect.model.Case;
import ru.kpfu.celect.model.Interview;
import ru.kpfu.celect.model.Model;
import ru.kpfu.celect.model.User;

import static ru.kpfu.celect.data.CelectServiceTestData.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyLong;
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

    User user = getUser();


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);


        //Мокирование userDao
        when(userDao.findByPhone(   PHONE_NUMBER))                  .thenReturn(user);
        when(userDao.findeUserById( user.getId()))             .thenReturn(user);
        when(userDao.insert(        user))                     .thenReturn(user);

        //Устновка вызова реальных методов в конвертере
        doCallRealMethod().when(convert).convert((User)         anyObject());
        doCallRealMethod().when(convert).convert((Case)         anyObject());
        doCallRealMethod().when(convert).convert((Interview)    anyObject());
        doCallRealMethod().when(convert).convert(               anyString());
        doCallRealMethod().when(convert).caseListToInterviewCasesDto(anyListOf(Case.class));
        doCallRealMethod().when(convert).interviewListToInterviewsDto(anyListOf(Interview.class));

    }

    @Test
    public void login(){
        assertEquals(celectService.login(getUser().getPhone_number()), getAuthDto());
    }

    @Test
    public void registration(){
        doReturn(user).when(convert).convert(PHONE_NUMBER);
        assertEquals(celectService.registeration(PHONE_NUMBER), getAuthDto());
    }

}
