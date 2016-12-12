package ru.kpfu.celect.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.kpfu.celect.dto.AuthDto;

/**
 * Created by Samat Khairutdinov on 12.12.16 18:50.
 * celect
 */
@RestController
public class UserController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResponseEntity<AuthDto> login(@RequestHeader String phone){
        return null;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ResponseEntity<AuthDto> registration(@RequestHeader String phone){
        return null;
    }


}
