package ru.kpfu.celect.dto;

import ru.kpfu.celect.model.AttempTest;
import ru.kpfu.celect.model.Question;

import java.util.List;

/**
 * Хранит вопросы для передачи данных
 *
 * @author Khairutdinov Samat
 * @since 23.01.2018
 */
public class QuestionsDto {

    private List<QuestionDto> questions;

    public List<QuestionDto> getQuestions() {
        return questions;
    }

    public QuestionsDto setQuestion(List<QuestionDto> attempTests) {
        this.questions = attempTests;
        return this;
    }
}
