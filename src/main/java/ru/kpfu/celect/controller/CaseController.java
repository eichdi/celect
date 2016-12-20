package ru.kpfu.celect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.celect.dto.CaseDto;
import ru.kpfu.celect.dto.InterviewCasesDto;
import ru.kpfu.celect.service.CelectService;

/**
 * Created by Samat Khairutdinov on 12.12.16 18:58.
 * celect
 */
@RestController
public class CaseController {
    @Autowired
    CelectService celectService;

    @RequestMapping(value = "/interview/{interview-id}/case", method = RequestMethod.GET)
    public ResponseEntity<InterviewCasesDto> getCases(@PathVariable("interview-id") int interviewId){
        return new ResponseEntity<>(celectService.getCase(interviewId), HttpStatus.OK);
    }

    @RequestMapping(value = "/interview/{interview-id}/case/{case-id}", method = RequestMethod.POST)
    public ResponseEntity<CaseDto> election(@PathVariable("interview-id") int interviewId,
                                            @PathVariable("case-id") int caseId,
                                            @RequestHeader("phone") String phone){
        return new ResponseEntity<>(celectService.election(interviewId, caseId, phone), HttpStatus.OK);
    }
}
