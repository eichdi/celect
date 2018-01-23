package ru.kpfu.celect.dao.repository;

import org.springframework.data.repository.CrudRepository;
import ru.kpfu.celect.model.Question;
import ru.kpfu.celect.model.Test;

import java.util.List;

/**
 * Получение из базы вопросы
 *
 * @author Khairutdinov Samat
 * @since 23.01.2018
 */
public interface QuestionRepository extends CrudRepository<Question, Integer> {
    List<Question> findByTest(Test test);
}
