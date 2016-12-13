package ru.kpfu.celect.dao.Impl;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.kpfu.celect.dao.ElectionsDao;
import ru.kpfu.celect.dao.mappers.ElectionsMapper;
import ru.kpfu.celect.model.Elections;

import javax.annotation.Resource;
import javax.sql.DataSource;import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Samat Khairutdinov on 13.10.16 18:25.
 * celect
 */
@Repository
public class ElectionsDaoImpl implements ElectionsDao, InitializingBean {

    private static final String SELECT_ALL_ELECTIONS_SQL = "SELECT * FROM elections";
    private static final String SELECT_BY_ID_ELECTIONS_SQL = "SELECT * FROM elections WHERE id = :id";
    private static final String COUNT_CASE_BY_ID_SQL = "SELECT count(*) FROM elections WHERE case_id = :case_id";
    private static final String COUNT_INTERVIEW_BY_ID_SQL = "SELECT count(*) FROM elections WHERE interview_id = :interview_id";
    private static final String INSERT_ELECTION_SQL = "INSERT INTO \"elections\" (interview_id, case_id, user_id)  VALUES (:interview_id, :case_id, :user_id)";

    @Autowired
    private DataSource dataSource;
    private NamedParameterJdbcTemplate jdbcTemplate;


    @Resource(name = "dataSource")
    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List findAll() {
        try{
            return jdbcTemplate.query(SELECT_ALL_ELECTIONS_SQL, new HashMap(),new ElectionsMapper());
        }
        catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public Elections findById(int id) {
        Map<String, Object> namedParam= new HashMap<>();
        namedParam.put("id", id);
        try {
            return jdbcTemplate.query(SELECT_BY_ID_ELECTIONS_SQL, namedParam, new ElectionsMapper()).get(0);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
        catch(IndexOutOfBoundsException e){
            return null;
        }
    }

    @Override
    public int countOfCase(int caseId) {
        Map<String, Object> namedParam = new HashMap<>();
        namedParam.put("case_id", caseId);

        try{
            return jdbcTemplate.query(COUNT_CASE_BY_ID_SQL, namedParam, resultSet -> {
                return resultSet.getInt(1);
            });
        }
        catch (EmptyResultDataAccessException e){
            return 0;
        }
    }

    @Override
    public int countOfInterview(int interviewId) {
        Map<String, Object> namedParam = new HashMap<>();
        namedParam.put("interview_id", interviewId);

        try{
            return jdbcTemplate.query(COUNT_INTERVIEW_BY_ID_SQL, namedParam, resultSet -> {
                return resultSet.getInt(1);
            });
        }
        catch (EmptyResultDataAccessException e){
            return 0;
        }
    }

    @Override
    public void insert(Elections elections) {
        Map<String, Object> namedParam = new HashMap<>();

        namedParam.put("interview_id", elections.getInterview().getId());
        namedParam.put("case_id", elections.getaCase().getId());
        namedParam.put("user_id", elections.getUser().getId());

        jdbcTemplate.update(INSERT_ELECTION_SQL, namedParam);
    }

    @Override
    public void insert(int interviewId, int caseId, int userId) {
        Map<String, Object> namedParam = new HashMap<>();

        namedParam.put("interview_id", interviewId);
        namedParam.put("case_id", caseId);
        namedParam.put("user_id", userId);

        jdbcTemplate.update(INSERT_ELECTION_SQL, namedParam);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if(dataSource == null){
            throw new BeanCreationException("Must set DataSourse on UserDao");
        }
    }

}
