package ru.kpfu.celect.dao.repository;

import org.springframework.data.repository.CrudRepository;
import ru.kpfu.celect.model.User;

/**
 * Created by Samat Khairutdinov on 13.04.17 14:38.
 * celect
 */

public interface UserRepository extends CrudRepository<User, Integer> {
}
