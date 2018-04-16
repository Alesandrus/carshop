package ru.treejoy.dao.services;

import ru.treejoy.model.geo.City;

import java.util.List;

/**
 * Service for city.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 10.04.2018
 */
public interface CityService extends EntityService<City> {
    /**
     * Saves city.
     *
     * @param entity city.
     */
    @Override
    void create(City entity);

    /**
     * Get all cities.
     *
     * @return list of cities.
     */
    @Override
    List<City> getAll();

    /**
     * Get city by ID.
     *
     * @param id city's.
     * @return city.
     */
    @Override
    City getByID(long id);

    /**
     * Update city.
     *
     * @param entity city.
     */
    @Override
    void update(City entity);

    /**
     * Delete city.
     *
     * @param entity city.
     */
    @Override
    void delete(City entity);

    /**
     * Get all cities for country.
     *
     * @param id country's.
     * @return list of cities.
     */
    List<City> findAllByCountryId(long id);
}