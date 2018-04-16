package ru.treejoy.dao.services;

import ru.treejoy.model.geo.Country;

import java.util.List;

/**
 * Service for country.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 10.04.2018
 */
public interface CountryService extends EntityService<Country> {
    /**
     * Saves country.
     *
     * @param entity country.
     */
    @Override
    void create(Country entity);

    /**
     * Get all countries.
     *
     * @return list of countries.
     */
    @Override
    List<Country> getAll();

    /**
     * Get country by ID.
     *
     * @param id country.
     * @return country.
     */
    @Override
    Country getByID(long id);

    /**
     * Update country.
     *
     * @param entity country.
     */
    @Override
    void update(Country entity);

    /**
     * Delete country.
     *
     * @param entity country.
     */
    @Override
    void delete(Country entity);
}