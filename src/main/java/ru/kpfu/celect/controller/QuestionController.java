package ru.kpfu.celect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.celect.dto.QuestionDto;
import ru.kpfu.celect.dto.QuestionsDto;
import ru.kpfu.celect.model.Question;
import ru.kpfu.celect.service.CelectService;

/**
 * Контроллер для вопросов
 *
 * @author Khairutdinov Samat
 * @since 23.01.2018
 */

@RestController
public class QuestionController {

    @Autowired
    CelectService celectService;

    @RequestMapping(value = "test/{test-id}/question", method = RequestMethod.GET)
    public ResponseEntity<QuestionsDto> getQuestions(@PathVariable("test-id") int testId){
        return new ResponseEntity<>(celectService.getQuestions(testId), HttpStatus.OK);
    }

    @RequestMapping(value = "question/{question-id}", method = RequestMethod.GET)
    public ResponseEntity<QuestionDto> getQuestion(@PathVariable("question-id") int questionId){
        return new ResponseEntity<>(celectService.getQuestion(questionId), HttpStatus.OK);
    }

    @RequestMapping(value = "question/{question-id}", method = RequestMethod.PUT)
    public ResponseEntity<QuestionDto> updateQuestion(@ModelAttribute Question question, @PathVariable("question-id") int questionId){
        return new ResponseEntity<>(celectService.saveQuestion(question.setId(questionId)), HttpStatus.OK);
    }

    @RequestMapping(value = "question", method = RequestMethod.POST)
    public ResponseEntity<QuestionDto> insertQuestion(@ModelAttribute Question caseDto){
        return new ResponseEntity<>(celectService.saveQuestion(caseDto), HttpStatus.OK);
    }
}
