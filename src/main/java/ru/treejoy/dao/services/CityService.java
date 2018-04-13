package ru.treejoy.dao.services;

import ru.treejoy.model.geo.City;

import java.util.List;

/**
 * Абстрактный класс DAO для города.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 31.01.2018
 */
public interface CityService extends EntityService<City> {
    /**
     * Создание сущности города.
     *
     * @param entity город.
     */
    @Override
    void create(City entity);

    /**
     * Получение всех городов.
     *
     * @return список городов.
     */
    @Override
    List<City> getAll();

    /**
     * Получение города по ID.
     *
     * @param id города.
     * @return город.
     */
    @Override
    City getByID(long id);

    /**
     * Обновить город.
     *
     * @param entity города.
     */
    @Override
    void update(City entity);

    /**
     * Удалить город.
     *
     * @param entity город.
     */
    @Override
    void delete(City entity);

    List<City> findAllByCountryId(long id);
}