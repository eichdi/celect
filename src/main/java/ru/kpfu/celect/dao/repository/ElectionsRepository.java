package ru.kpfu.celect.dao.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.kpfu.celect.model.Elections;

/**
 * Created by Samat Khairutdinov on 13.04.17 14:36.
 * celect
 */

public interface ElectionsRepository extends CrudRepository<Elections, Integer> {

//    @Query("SELECT count(e) FROM Elections WHERE e.celectCase.id = :case_id")
//    public int countOfCase(@Param("case_id")Integer caseId);
}
