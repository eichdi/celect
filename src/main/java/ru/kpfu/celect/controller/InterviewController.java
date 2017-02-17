package ru.kpfu.celect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.kpfu.celect.dto.AuthDto;
import ru.kpfu.celect.dto.InterviewsDto;
import ru.kpfu.celect.service.CelectService;

/**
 * Created by Samat Khairutdinov on 12.12.16 18:55.
 * celect
 */
@RestController
public class InterviewController {
    @Autowired
    CelectService celectService;

    @RequestMapping(value = "/interview", method = RequestMethod.GET)
    public ResponseEntity<InterviewsDto> getinterview(){
        return new ResponseEntity<>(celectService.getInterviews(), HttpStatus.OK);
    }
    //TODO: Создать POST метод для создания нового Interview
}
