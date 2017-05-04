package ru.kpfu.celect.dao.Impl.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kpfu.celect.dao.UserDao;
import ru.kpfu.celect.dao.repository.UserRepository;
import ru.kpfu.celect.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Samat Khairutdinov on 13.04.17 16:54.
 * celect
 */
@Repository
public class UserDaoJpaImpl implements UserDao{

    @Autowired
    UserRepository userRepository;
    

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().iterator().forEachRemaining(users :: add);
        return users;
    }

    @Override
    public User findByPhone(String phone) {
//        return userRepository.findByPhoneNumber(phone);
        return null;
    }

    @Override
    public User findeUserById(int id) {
        return userRepository.findOne(id);
    }

    @Override
    public User insert(User user) {
        return userRepository.save(user);
    }
}
