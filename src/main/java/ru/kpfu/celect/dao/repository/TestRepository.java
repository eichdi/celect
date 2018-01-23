package ru.kpfu.celect.dao.repository;

import org.springframework.data.repository.CrudRepository;
import ru.kpfu.celect.model.Test;


/**
 * Работа с базой для тестов
 *
 * @author Khairutdinov Samat
 * @since 23.01.2018
 */
public interface TestRepository  extends CrudRepository<Test, Integer> {
}
