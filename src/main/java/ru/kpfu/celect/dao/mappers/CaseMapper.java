package ru.kpfu.celect.dao.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.kpfu.celect.dao.InterviewDao;
import ru.kpfu.celect.model.Case;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Samat Khairutdinov on 09.10.2016 18:11.
 * celect
 */
@Component
public class CaseMapper implements RowMapper {

    @Autowired
    private InterviewDao interviewDao;

    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Case(
                resultSet.getInt("id"),
                interviewDao.findById(resultSet.getInt("interview_id")),
                resultSet.getString("main_info"),
                resultSet.getString("full_info")
        );
    }
}