package ru.kpfu.celect.dao.repository;

import org.springframework.data.repository.CrudRepository;
import ru.kpfu.celect.model.AttempTest;
import ru.kpfu.celect.model.Elections;
import ru.kpfu.celect.model.User;

import java.util.List;

/**
 * Created by Samat Khairutdinov on 13.04.17 14:36.
 * celect
 */

public interface ElectionsRepository extends CrudRepository<Elections, Integer> {

    List<Elections> findByUser(User user);
    List<Elections> findByAttempTest(AttempTest attempTest);
}
