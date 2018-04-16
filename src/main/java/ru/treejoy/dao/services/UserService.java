package ru.treejoy.dao.services;

import ru.treejoy.exceptions.CreateEmailException;
import ru.treejoy.exceptions.CreateLoginException;
import ru.treejoy.model.User;

import java.util.List;

/**
 * Service for user.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 10.04.2018
 */
public interface UserService extends EntityService<User> {
    /**
     * Saves user.
     *
     * @param entity user.
     * @throws CreateLoginException if data base contains same login.
     * @throws CreateEmailException if data base contains same email.
     */
    @Override
    void create(User entity) throws CreateLoginException, CreateEmailException;

    /**
     * Get all users.
     *
     * @return list of users.
     */
    @Override
    List<User> getAll();

    /**
     * Get user by ID.
     *
     * @param id user's.
     * @return user.
     */
    @Override
    User getByID(long id);

    /**
     * Update user.
     *
     * @param entity user.
     */
    @Override
    void update(User entity);

    /**
     * Delete user.
     *
     * @param entity user.
     */
    @Override
    void delete(User entity);

    /**
     * Get user by login and password.
     *
     * @param login    login.
     * @param password password.
     * @return user.
     */
    User getByLoginAndPassword(String login, String password);
}