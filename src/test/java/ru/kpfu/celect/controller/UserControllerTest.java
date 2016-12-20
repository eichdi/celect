package ru.kpfu.celect.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ru.kpfu.celect.dto.AuthDto;
import ru.kpfu.celect.dto.InterviewsDto;
import ru.kpfu.celect.service.CelectService;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.kpfu.celect.data.TestData.PHONE_NUMBER;
import static ru.kpfu.celect.data.TestData.getAuthDto;
import static ru.kpfu.celect.data.TestData.getInterviewsDto;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


/**
 * Created by Samat Khairutdinov on 20.12.16 17:25.
 * celect
 */
public class UserControllerTest {

    @InjectMocks
    private UserController userController = new UserController();

    @Mock
    CelectService celectService;

    private MockMvc mvc;

    ObjectMapper objectMapper = new ObjectMapper();

    AuthDto authDto = getAuthDto();


    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        mvc = MockMvcBuilders.standaloneSetup(userController).build();
        when(celectService.login(PHONE_NUMBER)).thenReturn(authDto);
        when(celectService.registeration(PHONE_NUMBER)).thenReturn(authDto);
    }

    @Test
    public void login() throws Exception{
        mvc.perform(get("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .header("phone", PHONE_NUMBER))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.phone").value(authDto.getPhone()));
    }

    @Test
    public void registration() throws Exception{
        mvc.perform(post("/registration")
                .contentType(MediaType.APPLICATION_JSON)
                .header("phone", PHONE_NUMBER))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.phone").value(authDto.getPhone()));
    }
}
