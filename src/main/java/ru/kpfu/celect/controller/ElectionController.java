package ru.kpfu.celect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.celect.dto.ElectionsDto;
import ru.kpfu.celect.model.Elections;
import ru.kpfu.celect.service.CelectService;

/**
 * Контроллер для ответов пользователя на вопросы
 *
 * @author Khairutdinov Samat
 * @since 23.01.2018
 */
@RequestMapping
public class ElectionController {

    @Autowired
    CelectService celectService;

    @RequestMapping(value = "user/{userId}/election", method = RequestMethod.GET)
    public ResponseEntity<ElectionsDto> getUserElections(@PathVariable("userId") int userId){
        return new ResponseEntity<>(celectService.getUserElections(), HttpStatus.OK);
    }

    @RequestMapping(value = "attempt/{attemptId}/elections", method = RequestMethod.GET)
    public ResponseEntity<ElectionsDto> getAttemptTests(@PathVariable("attemptId") int attemptId){
        return new ResponseEntity<>(celectService.getAttemptElections(attemptId), HttpStatus.OK);
    }

    @RequestMapping(value = "case", method = RequestMethod.POST)
    public ResponseEntity<Elections> insertCase(@ModelAttribute Elections elections){
        return new ResponseEntity<>(celectService.saveElections(elections), HttpStatus.OK);
    }
}
