package ru.kpfu.celect.dto;

import ru.kpfu.celect.model.Elections;

import java.util.List;

/**
 * Хранит выбор пользователя по вопросам
 *
 * @author Khairutdinov Samat
 * @since 23.01.2018
 */
public class ElectionsDto {
    private List<Elections> elections;

    public List<Elections> getElections() {
        return elections;
    }

    public ElectionsDto setElections(List<Elections> elections) {
        this.elections = elections;
        return this;
    }
}
