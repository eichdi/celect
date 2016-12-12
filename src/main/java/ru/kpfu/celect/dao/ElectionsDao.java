package ru.kpfu.celect.dao;

import ru.kpfu.celect.model.Elections;

import java.util.List;

/**
 * Created by Samat Khairutdinov on 13.10.16 17:38.
 * celect
 */
public interface ElectionsDao {

    List<Elections> findAll();
    Elections findById(int id);
    int countOfCase(int caseId);
    int countOfInterview(int interviewId);
    void insert(Elections elections);
}
