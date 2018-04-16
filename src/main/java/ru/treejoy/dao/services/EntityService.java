package ru.treejoy.dao.services;

import ru.treejoy.exceptions.CreateEmailException;
import ru.treejoy.exceptions.CreateLoginException;

import java.util.List;

/**
 * Entity service.
 *
 * @param <E> element.
 * @author Alexander Ivanov
 * @version 1.0
 * @since 10.04.2018
 */
public interface EntityService<E> {
    /**
     * Saves entity.
     *
     * @param entity entity.
     * @throws Exception .
     */
    void create(E entity) throws Exception;

    /**
     * Get all entities.
     *
     * @return list of entities.
     */
    List<E> getAll();

    /**
     * Get entity by ID.
     *
     * @param id entity's.
     * @return entity.
     */
    E getByID(long id);

    /**
     * Update entity.
     *
     * @param entity entity.
     */
    void update(E entity);

    /**
     * Delete entity.
     *
     * @param entity entity.
     */
    void delete(E entity);
}
