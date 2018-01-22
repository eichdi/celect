package ru.kpfu.celect.dao.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.kpfu.celect.model.CelectCase;
import ru.kpfu.celect.model.Question;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * Created by Samat Khairutdinov on 12.04.17 16:58.
 * celect
 */
public interface CaseRepository extends CrudRepository<CelectCase, Integer> {

    List<CelectCase> findByQuestion(Question question);


}
