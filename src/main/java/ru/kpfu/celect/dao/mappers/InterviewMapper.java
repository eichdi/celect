package ru.kpfu.celect.dao.mappers;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.kpfu.celect.model.Interview;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Samat Khairutdinov on 09.10.2016 18:12.
 * celect
 */
@Component
public class InterviewMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Interview(
                resultSet.getString("info"),
                resultSet.getInt("id")
        );
    }
}