package ru.kpfu.celect.dao.repository;

import org.springframework.data.repository.CrudRepository;
import ru.kpfu.celect.model.AttempTest;
import ru.kpfu.celect.model.User;

import java.util.List;

/**
 * Получение из базы попыток теста
 *
 * @author Khairutdinov Samat
 * @since 23.01.2018
 */
public interface AttempTestRepository extends CrudRepository<AttempTest, Integer> {
    List<AttempTest> findByUser(User user);
}
