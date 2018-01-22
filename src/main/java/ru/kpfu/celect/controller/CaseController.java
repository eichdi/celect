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

    @RequestMapping(value = "question/{questinon-id}/case", method = RequestMethod.GET)
    public ResponseEntity<InterviewCasesDto> getCases(@PathVariable("questinon-id") int questionId){
        return new ResponseEntity<>(celectService.getCases(questionId), HttpStatus.OK);
    }

    @RequestMapping(value = "hello",  method = RequestMethod.GET)
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("darkness my old friend", HttpStatus.OK);
    }

    @RequestMapping(value = "/case/{case-id}", method = RequestMethod.GET)
    public ResponseEntity<CaseDto> getCase(@PathVariable("case-id") int caseId){
        return new ResponseEntity<>(celectService.getCase(caseId), HttpStatus.OK);
    }

    @RequestMapping(value = "/case/{case-id}", method = RequestMethod.PUT)
    public ResponseEntity<CaseDto> updateCase(@ModelAttribute("case") CaseDto caseDto){
        return new ResponseEntity<>(celectService.saveCase(caseDto), HttpStatus.OK);
    }

    @RequestMapping(value = "/case", method = RequestMethod.POST)
    public ResponseEntity<CaseDto> insertCase(){
        return new ResponseEntity<>(celectService.saveCase(null), HttpStatus.OK);
    }
}
