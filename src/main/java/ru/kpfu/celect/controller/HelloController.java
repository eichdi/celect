package ru.kpfu.celect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Samat Khairutdinov on 06.10.2016 19:47.
 * celect
 */
@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {

        return "CELECT!";
    }

}
