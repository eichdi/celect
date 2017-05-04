package ru.kpfu.celect.dao.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.kpfu.celect.dao.InterviewDao;
import ru.kpfu.celect.model.CelectCase;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Samat Khairutdinov on 09.10.2016 18:11.
 * celect
 */

/**
 * Да, использовать в мапперах DAO плохая мысль,
 * но это прикольно. Сделано именно так только для скорости разработки.
 */
@Component
public class CaseMapper implements RowMapper<CelectCase> {

    @Autowired
    private InterviewDao interviewDao;

    @Override
    public CelectCase mapRow(ResultSet resultSet, int i) throws SQLException {
        return new CelectCase(
                resultSet.getInt("id"),
                interviewDao.findById(resultSet.getInt("interview_id")),
                resultSet.getString("main_info"),
                resultSet.getString("full_info")
        );
    }
}