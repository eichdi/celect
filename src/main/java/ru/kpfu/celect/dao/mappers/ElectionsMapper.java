package ru.kpfu.celect.dao.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.kpfu.celect.dao.CaseDao;
import ru.kpfu.celect.dao.InterviewDao;
import ru.kpfu.celect.dao.UserDao;
import ru.kpfu.celect.dao.Impl.CaseDaoImpl;
import ru.kpfu.celect.dao.Impl.InterviewDaoImpl;
import ru.kpfu.celect.dao.Impl.UserDaoImpl;
import ru.kpfu.celect.model.Elections;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Samat Khairutdinov on 09.10.2016 18:12.
 * celect
 */
@Component
public class ElectionsMapper implements RowMapper<Elections> {

    @Autowired
    CaseDao caseDao = new CaseDaoImpl();
    @Autowired
    InterviewDao interviewDao = new InterviewDaoImpl();
    @Autowired
    UserDao userDao = new UserDaoImpl();

    @Override
    public Elections mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Elections(
            interviewDao.findById(resultSet.getInt("interview_id")),
            caseDao.findById(resultSet.getInt("case_id")),
            userDao.findeUserById(resultSet.getInt("user_id"))
        );
    }
}
