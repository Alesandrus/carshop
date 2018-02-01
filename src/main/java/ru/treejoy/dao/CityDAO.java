package ru.treejoy.dao;

import ru.treejoy.model.geo.City;

import java.util.List;

/**
 * Абстрактный класс DAO для города.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 31.01.2018
 */
public abstract class CityDAO implements EntityDAO<City> {
    /**
     * Создание сущности города.
     *
     * @param entity город.
     */
    @Override
    public abstract void create(City entity);

    /**
     * Получение всех городов.
     *
     * @return список городов.
     */
    @Override
    public abstract List<City> getAll();

    /**
     * Получение города по ID.
     *
     * @param id города.
     * @return город.
     */
    @Override
    public abstract City getByID(long id);

    /**
     * Обновить город.
     *
     * @param entity города.
     */
    @Override
    public abstract void update(City entity);

    /**
     * Удалить город.
     *
     * @param entity город.
     */
    @Override
    public abstract void delete(City entity);
}