package ru.kpfu.celect.dao.Impl;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.kpfu.celect.dao.CaseDao;
import ru.kpfu.celect.dao.mappers.CaseMapper;
import ru.kpfu.celect.model.Case;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Samat Khairutdinov on 13.10.16 17:26.
 * celect
 */
@Repository
public class CaseDaoImpl implements CaseDao, InitializingBean {

    private static final String SELECT_ALL_SQL = "SELECT * FROM \"case\"";
    private static final String SELECT_CASE_BY_ID_SQL = "SELECT * FROM \"case\" WHERE id = :id";
    private static final String INSERT_CASE_SQL = "INSERT INTO \"case\" (main_info, full_info, interview_id) VALUES (:main_info, :full_info, :interview_id)";
    private static final String UPDATE_CASE_SQL = "UPDATE \"case\" SET main_info=:main_info, full_info = :full_info, interview_id = :interview_id WHERE id = :id";
    private static final String DELETE_CASE_SQL = "DELETE FROM \"case\" WHERE id = :id";
    private static final String SELECT_BY_INTERVIEW_SQL = "SELECT * FROM \"case\" WHERE interview_id = :interview_id ";


    @Autowired
    private DataSource dataSource;
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private CaseMapper caseMapper;


    @Resource(name = "dataSource")
    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }



    @Override
    public List findAll() {
        try{
            return jdbcTemplate.query(SELECT_ALL_SQL, new HashMap(),caseMapper);
        }
        catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public Case findById(int id) {
        Map<String, Object> namedParam = new HashMap<>();
        namedParam.put("id", id);
        try {
            return jdbcTemplate.queryForObject(SELECT_CASE_BY_ID_SQL, namedParam, caseMapper);
            //return jdbcTemplate.query(SELECT_CASE_BY_ID_SQL, namedParam, new CaseMapper()).get(0);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public void insert(Case aCase) {
        Map<String, Object> namedParam = new HashMap<>();
        namedParam.put("interview_id", aCase.getInterview().getId());
        namedParam.put("full_info", aCase.getFullInfo());
        namedParam.put("main_info", aCase.getMainInfo());
        jdbcTemplate.update(INSERT_CASE_SQL, namedParam);
    }

    @Override
    public void update(Case aCase, int id) {
        Map<String, Object> namedParam = new HashMap<>();
        namedParam.put("id", id);
        namedParam.put("interview_id", aCase.getInterview().getId());
        namedParam.put("full_info", aCase.getFullInfo());
        namedParam.put("main_info", aCase.getMainInfo());
        jdbcTemplate.update(UPDATE_CASE_SQL, namedParam);
    }

    @Override
    public void delete(int id) {
        Map<String, Object> namedParam= new HashMap<>();
        namedParam.put("id", id);
        jdbcTemplate.update(DELETE_CASE_SQL, namedParam);
    }



    @Override
    public List<Case> findByInterview(int interviewId) {
        Map<String, Object> namedParam = new HashMap<>();
        namedParam.put("interview_id", interviewId);
        try{
            return jdbcTemplate.query(SELECT_BY_INTERVIEW_SQL, namedParam, caseMapper);
        }
        catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if(dataSource == null){
            throw new BeanCreationException("Must set DataSourse on CaseDao");
        }
    }
}
