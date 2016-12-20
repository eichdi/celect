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
import ru.kpfu.celect.dto.CaseDto;
import ru.kpfu.celect.dto.InterviewCasesDto;
import ru.kpfu.celect.service.CelectService;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.kpfu.celect.data.TestData.*;

/**
 * Created by Samat Khairutdinov on 19.12.16 17:17.
 * celect
 */
public class CaseControllerTest {
    @InjectMocks
    private CaseController caseController = new CaseController();

    @Mock
    CelectService celectService;

    private MockMvc mvc;

    ObjectMapper objectMapper = new ObjectMapper();

    AuthDto authDto = getAuthDto();

    InterviewCasesDto interviewCasesDto = getInterviewCasesDto();

    CaseDto caseDto = getCaseDto();



    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        mvc = MockMvcBuilders.standaloneSetup(caseController).build();
        when(celectService.getCase(INTERVIEW_ID)).thenReturn(interviewCasesDto);
        when(celectService.election(INTERVIEW_ID, CASE_ID, PHONE_NUMBER)).thenReturn(caseDto);
    }

    @Test
    public void getAllAdvertisers() throws Exception {
        mvc.perform(get("/interview/"+INTERVIEW_ID+"/case")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.caseDtoList[0].id").value(interviewCasesDto.getCaseDtoList().get(0).getId()))
            .andExpect(jsonPath("$.caseDtoList[0].mainInfo").value(interviewCasesDto.getCaseDtoList().get(0).getMainInfo()))
            .andExpect(jsonPath("$.caseDtoList[0].fullInfo").value(interviewCasesDto.getCaseDtoList().get(0).getFullInfo()))
            .andExpect(jsonPath("$.caseDtoList[1].id").value(interviewCasesDto.getCaseDtoList().get(1).getId()))
            .andExpect(jsonPath("$.caseDtoList[1].mainInfo").value(interviewCasesDto.getCaseDtoList().get(1).getMainInfo()))
            .andExpect(jsonPath("$.caseDtoList[1].fullInfo").value(interviewCasesDto.getCaseDtoList().get(1).getFullInfo()));
    }

    @Test
    public void election() throws Exception {
        mvc.perform(post("/interview/"+INTERVIEW_ID+"/case/"+CASE_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .header("phone", PHONE_NUMBER))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(caseDto.getId()))
                .andExpect(jsonPath("$.mainInfo").value(caseDto.getMainInfo()))
                .andExpect(jsonPath("$.fullInfo").value(caseDto.getFullInfo()));
    }



}
