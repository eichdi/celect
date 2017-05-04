package ru.kpfu.celect.dao.Impl.jdbc;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.kpfu.celect.dao.UserDao;
import ru.kpfu.celect.dao.mappers.UserMapper;
import ru.kpfu.celect.model.User;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Samat Khairutdinov on 13.10.16 16:41.
 * celect
 */
@Repository
public class UserDaoImpl implements UserDao, InitializingBean {

    private static final String SELECT_ALL_SQL = "SELECT * FROM celect_user";
    private static final String SELECT_BY_PHONE_SQL = "SELECT * FROM celect_user WHERE phone_number = :phone_number";
    private static final String SELECT_USER_BY_ID_SQL = "SELECT * FROM celect_user WHERE id = :userId";
    private static final String INSERT_USER_SQL = "INSERT INTO celect_user (phone_number) values (:phone_number) RETURNING *";
    private static final String UPDETE_USER_SQL = "UPDATE celect_user SET phone_number = :phone_number WHERE id = :userId";
    private static final String DELETE_USER_SQL = "DELETE FROM celect_user WHERE id = :userId";


    private DataSource dataSource;
    private NamedParameterJdbcTemplate jdbcTemplate;


    @Autowired
    @Resource(name = "dataSource")
    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<User> findAll() {
        try{
            return jdbcTemplate.query(SELECT_ALL_SQL, new HashMap(),new UserMapper());
        }
        catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public User findByPhone(String phone) {
        Map<String, String> namedParam= new HashMap<>();
        namedParam.put("phone_number", phone);
        try{
            return jdbcTemplate.query(SELECT_BY_PHONE_SQL, namedParam, new UserMapper()).get(0);}
        catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public User findeUserById(int id) {
        Map<String, Object> namedParam= new HashMap<>();
        namedParam.put("userId", id);
        try {
            return jdbcTemplate.query(SELECT_USER_BY_ID_SQL, namedParam, new UserMapper()).get(0);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
        catch(IndexOutOfBoundsException e){
            return null;
        }
    }

    @Override
    public User insert(User user) {
        Map<String, Object> namedParam = new HashMap<>();

        namedParam.put("phone_number", user.getPhoneNumber());

        return jdbcTemplate.queryForObject(INSERT_USER_SQL, namedParam, new UserMapper());
    }

    public void update(User user, int id) {
        Map<String, Object> namedParam = new HashMap<>();
        namedParam.put("phone_number", user.getPhoneNumber());
        namedParam.put("userId", id);

        jdbcTemplate.update(UPDETE_USER_SQL, namedParam);
    }

    public void delete(User user) {
        this.delete(user.getId());
    }

    public void delete(int id) {
        Map<String, Object> namedParam = new HashMap<>();
        namedParam.put("userId", id);

        jdbcTemplate.update(DELETE_USER_SQL, namedParam);
    }

    //Реализация InitializingBean
    @Override
    public void afterPropertiesSet() throws Exception {
        if(dataSource == null){
            throw new BeanCreationException("Must set DataSourse on UserDao");
        }
    }
}
