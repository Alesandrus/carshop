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
    /**
     * Find user by login and password.
     * @param login of user.
     * @param password of user.
     * @return user.
     */
    User findByLoginAndPassword(String login, String password);

    /**
     * Find all users by login or email.
     * @param login of user.
     * @param email of user.
     * @return List of users.
     */
    List<User> findAllByLoginOrEmail(String login, String email);
}
