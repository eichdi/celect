package ru.kpfu.celect.dao.mappers;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.kpfu.celect.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Samat Khairutdinov on 09.10.2016 18:12.
 * celect
 */
@Component
public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        return new User(
                resultSet.getString("phone_number"),
                resultSet.getInt("id")
        );
    }
}