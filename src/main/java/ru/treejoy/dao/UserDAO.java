package ru.treejoy.dao;

import ru.treejoy.exceptions.CreateEmailException;
import ru.treejoy.exceptions.CreateLoginException;
import ru.treejoy.model.User;

import java.util.List;

/**
 * Абстрактный класс DAO для сущности пользователя.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 31.01.2018
 */
public abstract class UserDAO implements EntityDAO<User> {
    /**
     * Создание сущности пользователя.
     *
     * @param entity пользователь.
     */
    @Override
    public abstract void create(User entity) throws Exception;

    /**
     * Получение всех пользователей.
     *
     * @return список пользователей.
     */
    @Override
    public abstract List<User> getAll();

    /**
     * Получение пользователя по ID.
     *
     * @param id пользователя.
     * @return пользователя.
     */
    @Override
    public abstract User getByID(long id);

    /**
     * Обновить пользователя.
     *
     * @param entity пользователь.
     */
    @Override
    public abstract void update(User entity);

    /**
     * Удалить пользователя.
     *
     * @param entity пользователь.
     */
    @Override
    public abstract void delete(User entity);


    public abstract User validate(String login, String password);
}