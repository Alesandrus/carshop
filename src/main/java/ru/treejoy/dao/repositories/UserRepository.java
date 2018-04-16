package ru.treejoy.dao.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.treejoy.model.User;

import java.util.List;

/**
 * UserRepository.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 10.04.2018
 */
public interface UserRepository extends CrudRepository<User, Long> {
    User findByLoginAndPassword(String login, String password);
    List<User> findAllByLoginOrEmail(String login, String email);
}
