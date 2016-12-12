package ru.kpfu.celect.dao;

import ru.kpfu.celect.model.Elections;
import ru.kpfu.celect.model.Interview;
import ru.kpfu.celect.model.User;

import java.util.List;

/**
 * Created by Samat Khairutdinov on 13.10.16 17:10.
 * celect
 */
public interface InterviewDao {
    List<Elections> findAll();
    Interview findById(int id);
    void insert(Interview interview);
    void update(Interview interview, int id);
    void delete(int id);

}
