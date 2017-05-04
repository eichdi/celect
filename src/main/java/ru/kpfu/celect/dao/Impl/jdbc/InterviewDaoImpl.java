package ru.kpfu.celect.dao.Impl.jdbc;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.kpfu.celect.dao.InterviewDao;
import ru.kpfu.celect.dao.mappers.InterviewMapper;
import ru.kpfu.celect.model.Interview;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Samat Khairutdinov on 13.10.16 17:11.
 * celect
 */
@Repository
public class InterviewDaoImpl implements InterviewDao, InitializingBean {

    private static final String SELECT_ALL_INTERVIEW_SQL = "SELECT * FROM interview";
    private static final String SELECT_INTERVIEW_BY_ID_SQL = "SELECT * FROM interview WHERE id = :interviewId";
    private static final String INSERT_INTERVIEW_SQL = "INSERT INTO interview (info) VALUES (:info)";
    private static final String UPDATE_INTERVIEW_SQL = "UPDATE interview SET info = :info WHERE id = :id";
    private static final String DELETE_INTERVIEW_SQL = "DELETE FROM interview WHERE id = :id";


    @Autowired
    private DataSource dataSource;
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private InterviewMapper interviewMapper;


    @Resource(name = "dataSource")
    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }


    @Override
    public List<Interview> findAll() {
        try{
            return jdbcTemplate.query(SELECT_ALL_INTERVIEW_SQL, new HashMap(),new InterviewMapper());
        }
        catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public Interview findById(int id) {
        Map<String, Object> namedParam= new HashMap<>();
        namedParam.put("interviewId", id);
        try {
            return jdbcTemplate.query(SELECT_INTERVIEW_BY_ID_SQL, namedParam, interviewMapper).get(0);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
        catch(IndexOutOfBoundsException e){
            return null;
        }
    }

    @Override
    public void insert(Interview interview) {
        Map<String, Object> namedParam = new HashMap<>();

        namedParam.put("info", interview.getInfo());

        jdbcTemplate.update(INSERT_INTERVIEW_SQL, namedParam);
    }

    @Override
    public void update(Interview interview, int id) {

        Map<String, Object> namedParam= new HashMap<>();
        namedParam.put("info", interview.getInfo());
        namedParam.put("id", id);

        jdbcTemplate.update(UPDATE_INTERVIEW_SQL, namedParam);

    }

    @Override
    public void delete(int id) {
        Map<String, Object> namedParam= new HashMap<>();
        namedParam.put("id", id);

        jdbcTemplate.update(DELETE_INTERVIEW_SQL, namedParam);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if(dataSource == null){
            throw new BeanCreationException("Must set DataSourse on InterviewDao");
        }
    }

}
