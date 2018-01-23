package ru.kpfu.celect.dto;

import ru.kpfu.celect.model.AttempTest;

import java.util.List;

/**
 * Попытка прохождения теста
 *
 * @author Khairutdinov Samat
 * @since 23.01.2018
 */
public class AttempTestsDto {
    private List<AttempTest> attempTests;

    public List<AttempTest> getAttempTests() {
        return attempTests;
    }

    public AttempTestsDto setAttempTests(List<AttempTest> attempTests) {
        this.attempTests = attempTests;
        return this;
    }
}
