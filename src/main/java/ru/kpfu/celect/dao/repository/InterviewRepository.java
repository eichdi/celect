package ru.kpfu.celect.dao.repository;

import org.springframework.data.repository.CrudRepository;
import ru.kpfu.celect.model.Question;

/**
 * Created by Samat Khairutdinov on 13.04.17 14:37.
 * celect
 */

public interface InterviewRepository extends CrudRepository<Question, Long> {
}
