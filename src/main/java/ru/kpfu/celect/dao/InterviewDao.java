package ru.kpfu.celect.dao;

import ru.kpfu.celect.model.Question;

import java.util.List;

/**
 * Created by Samat Khairutdinov on 13.10.16 17:10.
 * celect
 */
public interface InterviewDao {
    List<Question> findAll();
    Question findById(int id);
    void insert(Question question);
    void update(Question question, int id);
    void delete(int id);

}
