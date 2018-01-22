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
import ru.kpfu.celect.dto.InterviewsDto;
import ru.kpfu.celect.service.CelectService;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.kpfu.celect.data.TestData.*;

/**
 * Created by Samat Khairutdinov on 20.12.16 16:50.
 * celect
 */
public class QuestionControllerTest {

    @InjectMocks
    private InterviewController interviewController = new InterviewController();

    @Mock
    CelectService celectService;

    private MockMvc mvc;

    ObjectMapper objectMapper = new ObjectMapper();

    InterviewsDto interviewCasesDto = getInterviewsDto();


    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        mvc = MockMvcBuilders.standaloneSetup(interviewController).build();
        when(celectService.getInterviews()).thenReturn(interviewCasesDto);
    }

    @Test
    public void getinterview() throws Exception {
        mvc.perform(get("/interview")
        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.interviewDtoList[0].id").value(interviewCasesDto.getInterviewDtoList().get(0).getId()))
                .andExpect(jsonPath("$.interviewDtoList[0].info").value(interviewCasesDto.getInterviewDtoList().get(0).getInfo()))
                .andExpect(jsonPath("$.interviewDtoList[1].id").value(interviewCasesDto.getInterviewDtoList().get(1).getId()))
                .andExpect(jsonPath("$.interviewDtoList[1].info").value(interviewCasesDto.getInterviewDtoList().get(1).getInfo()));
    }
}
