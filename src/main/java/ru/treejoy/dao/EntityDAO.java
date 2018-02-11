package ru.treejoy.dao;

import java.util.List;

/**
 * Интерфейс сущности.
 *
 * @param <E> element.
 * @author Alexander Ivanov
 * @version 1.0
 * @since 31.01.2018
 */
public interface EntityDAO<E> {
    /**
     * Создание сущности.
     *
     * @param entity сущность.
     * @throws Exception .
     */
    void create(E entity) throws Exception;

    /**
     * Получение всех сущностей.
     *
     * @return список сущностей.
     */
    List<E> getAll();

    /**
     * Получение сущности по ID.
     *
     * @param id сущности.
     * @return сущность.
     */
    E getByID(long id);

    /**
     * Обновить сущность.
     *
     * @param entity сущность.
     */
    void update(E entity);

    /**
     * Удалить сущность.
     *
     * @param entity сущность.
     */
    void delete(E entity);
}
