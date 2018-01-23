package ru.kpfu.celect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.celect.dto.AttempTestsDto;
import ru.kpfu.celect.model.AttempTest;
import ru.kpfu.celect.service.CelectService;

/**
 * Контроллер для попыток теста
 *
 * @author Khairutdinov Samat
 * @since 23.01.2018
 */

@RestController
public class AttempTestController {

    @Autowired
    CelectService celectService;

    @RequestMapping(value = "attempt", method = RequestMethod.GET)
    public ResponseEntity<AttempTestsDto> getAttemptTests(){
        return new ResponseEntity<>(celectService.getAttemptsTest(), HttpStatus.OK);
    }

    @RequestMapping(value = "user/{userId}/attempt", method = RequestMethod.GET)
    public ResponseEntity<AttempTestsDto> getAttemptTests(@PathVariable("user-id") int userId){
        return new ResponseEntity<>(celectService.getAttemptsTest(userId), HttpStatus.OK);
    }

    @RequestMapping(value = "attempt", method = RequestMethod.POST)
    public ResponseEntity<AttempTest> createAttemptTest(@RequestParam("userId") int userId, @RequestParam("testId") int testId){
        return new ResponseEntity<>(celectService.createAttempTest(userId, testId), HttpStatus.OK);
    }
}
