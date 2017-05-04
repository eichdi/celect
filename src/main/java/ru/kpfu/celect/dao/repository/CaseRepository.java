package ru.kpfu.celect.dao.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.kpfu.celect.model.CelectCase;

import java.util.List;

/**
 * Created by Samat Khairutdinov on 12.04.17 16:58.
 * celect
 */

public interface CaseRepository extends CrudRepository<CelectCase, Integer> {
//    // TODO: 13.04.17 fix me
//    @Query("select p from CelectCase p WHERE p.interview_id = :interview_id ")
//    public List<CelectCase> findByInterview(@Param("interview_id") int interview_id);
}
