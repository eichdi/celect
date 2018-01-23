package ru.kpfu.celect.dto;

import ru.kpfu.celect.model.Question;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * TODO Class Description
 *
 * @author Khairutdinov Samat
 * @since 23.01.2018
 */
public class TestDto {
    private int id;

    private String description;

    private List<Question> questions;

    public int getId() {
        return id;
    }

    public TestDto setId(int id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TestDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public TestDto setQuestions(List<Question> questions) {
        this.questions = questions;
        return this;
    }
}
