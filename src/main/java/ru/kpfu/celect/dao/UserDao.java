package ru.kpfu.celect.dao;

import ru.kpfu.celect.model.User;

import java.util.List;

/**
 * Created by Samat Khairutdinov on 07.10.2016 12:05.
 * celect
 */
public interface UserDao {
    List<User> findAll();
    List<User> findByPhone(String phone);
    User findeUserById(int id);
    void insert(User user);
}
