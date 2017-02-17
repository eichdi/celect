package ru.kpfu.celect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ru.kpfu.celect.service.CelectService;

/**
 * Created by Samat Khairutdinov on 15.12.16 17:20.
 * celect
 */
// TODO: 17.02.17 Добавить возможность получения всех голосов
// TODO: 17.02.17 Добавить возможность получение статистики относительно X и проголосовавших за тот или иной вариант
@RestController
public class ElectionsController {

    @Autowired
    CelectService celectService;
}
