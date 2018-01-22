package ru.kpfu.celect.dao;

import ru.kpfu.celect.model.CelectCase;

import java.util.List;

/**
 * Created by Samat Khairutdinov on 13.10.16 17:24.
 * celect
 */
public interface CaseDao {
    List<CelectCase> findAll();
    CelectCase findById(int id);
    void insert(CelectCase aCelectCase);
    void update(CelectCase aCelectCase);
    void delete(int id);
    List<CelectCase> findByInterview(int interviewId);
}
