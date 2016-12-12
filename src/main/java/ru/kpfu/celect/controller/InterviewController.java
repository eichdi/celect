package ru.kpfu.celect.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.kpfu.celect.dto.AuthDto;
import ru.kpfu.celect.dto.InterviewsDto;

/**
 * Created by Samat Khairutdinov on 12.12.16 18:55.
 * celect
 */
@RestController
public class InterviewController {

    @RequestMapping(value = "/interview", method = RequestMethod.GET)
    public ResponseEntity<InterviewsDto> getinterview(){
        return null;
    }
}
