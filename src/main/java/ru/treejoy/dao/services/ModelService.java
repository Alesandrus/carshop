package ru.treejoy.dao.services;

import ru.treejoy.model.brands.Model;

import java.util.List;

/**
 * Service for model.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 10.04.2018
 */
public interface ModelService extends EntityService<Model> {
    /**
     * Saves model.
     *
     * @param entity model.
     */
    @Override
    void create(Model entity);

    /**
     * Get all models.
     *
     * @return list of models.
     */
    @Override
    List<Model> getAll();

    /**
     * Get model by ID.
     *
     * @param id model's.
     * @return model's.
     */
    @Override
    Model getByID(long id);

    /**
     * Update model.
     *
     * @param entity model.
     */
    @Override
    void update(Model entity);

    /**
     * Delete model.
     *
     * @param entity model.
     */
    @Override
    void delete(Model entity);

    /**
     * Get all models by brand.
     *
     * @param id brand's.
     * @return list of models.
     */
    List<Model> findAllByBrandID(long id);
}