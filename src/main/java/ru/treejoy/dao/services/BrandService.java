package ru.treejoy.dao.services;

import ru.treejoy.model.brands.Brand;

import java.util.List;

/**
 * Service for brand.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 10.04.2018
 */
public interface BrandService extends EntityService<Brand> {
    /**
     * Saves brand.
     *
     * @param entity brand.
     */
    @Override
    void create(Brand entity);

    /**
     * Get all brands.
     *
     * @return list of brands.
     */
    @Override
    List<Brand> getAll();

    /**
     * Get brand by ID.
     *
     * @param id brand.
     * @return brand.
     */
    @Override
    Brand getByID(long id);

    /**
     * Update brand.
     *
     * @param entity brand.
     */
    @Override
    void update(Brand entity);

    /**
     * Delete brand.
     *
     * @param entity brand.
     */
    @Override
    void delete(Brand entity);
}