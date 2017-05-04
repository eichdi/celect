package ru.kpfu.celect.dao.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.kpfu.celect.model.User;

/**
 * Created by Samat Khairutdinov on 13.04.17 14:38.
 * celect
 */

public interface UserRepository extends CrudRepository<User, Integer> {
//
//    @Query(value = "select user from User where user.phoneNumber = :phone")
//    public User findByPhoneNumber(@Param("phone") String phone);

}
