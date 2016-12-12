package ru.kpfu.celect.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.celect.dto.AuthDto;
import ru.kpfu.celect.dto.InterviewCasesDto;

/**
 * Created by Samat Khairutdinov on 12.12.16 18:58.
 * celect
 */
@RestController
public class CaseController {

    @RequestMapping(value = "/interview/{interview-id}/case", method = RequestMethod.GET)
    public ResponseEntity<InterviewCasesDto> getCases(@PathVariable("interview-id") int interviewId){
        return null;
    }

    @RequestMapping(value = "/interview/{interview-id}/case/{case-id}", method = RequestMethod.GET)
    public ResponseEntity<InterviewCasesDto> election(@PathVariable("interview-id") int interviewId,
                                                      @PathVariable("case-id") int caseId,
                                                      @RequestHeader("phone") String phone){
        return null;
    }
}
