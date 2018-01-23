package ru.kpfu.celect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.celect.dto.AuthDto;
import ru.kpfu.celect.model.User;
import ru.kpfu.celect.service.CelectService;

/**
 * Created by Samat Khairutdinov on 12.12.16 18:50.
 * celect
 */


@RestController
public class UserController {
    @Autowired
    CelectService celectService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResponseEntity<AuthDto> login(@RequestHeader String phone){
        return new ResponseEntity<>(celectService.login(phone), HttpStatus.OK);
    }


    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ResponseEntity<User> registration(@ModelAttribute User user){
        return new ResponseEntity<>(celectService.registeration(user), HttpStatus.OK);
    }


}
