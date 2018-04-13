package ru.treejoy.dao.services;

import ru.treejoy.model.User;

import java.util.List;

/**
 * Абстрактный класс DAO для сущности пользователя.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 31.01.2018
 */
public interface UserService extends EntityService<User> {
    /**
     * Создание сущности пользователя.
     *
     * @param entity пользователь.
     */
    @Override
    void create(User entity) throws Exception;

    /**
     * Получение всех пользователей.
     *
     * @return список пользователей.
     */
    @Override
    List<User> getAll();

    /**
     * Получение пользователя по ID.
     *
     * @param id пользователя.
     * @return пользователя.
     */
    @Override
    User getByID(long id);

    /**
     * Обновить пользователя.
     *
     * @param entity пользователь.
     */
    @Override
    void update(User entity);

    /**
     * Удалить пользователя.
     *
     * @param entity пользователь.
     */
    @Override
    void delete(User entity);

    /**
     * Получить пользователя по логину и паролю.
     *
     * @param login    логин.
     * @param password пароль.
     * @return пользователя.
     */
    User getByLoginAndPassword(String login, String password);
}