package ru.kpfu.celect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ru.kpfu.celect.service.CelectService;

/**
 * Created by Samat Khairutdinov on 15.12.16 17:20.
 * celect
 */
@RestController
public class ElectionsController {

    @Autowired
    CelectService celectService;
}
