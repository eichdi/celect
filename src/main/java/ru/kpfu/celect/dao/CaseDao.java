package ru.kpfu.celect.dao;

import ru.kpfu.celect.model.Case;
import ru.kpfu.celect.model.User;

import java.util.List;

/**
 * Created by Samat Khairutdinov on 13.10.16 17:24.
 * celect
 */
public interface CaseDao {
    List<Case> findAll();
    Case findById(int id);
    void insert(Case aCase);
    void update(Case user, int id);
    void delete(int id);
    List<Case> findByInterview(int interviewId);
}
