package ru.treejoy.dao.services;

import ru.treejoy.model.brands.Brand;

import java.util.List;

/**
 * Сервис для марки автомобиля.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 31.01.2018
 */
public interface BrandService extends EntityService<Brand> {
    /**
     * Создание марки авто.
     *
     * @param entity марка авто.
     */
    @Override
    void create(Brand entity);

    /**
     * Получение всех марок авто.
     *
     * @return список марок авто.
     */
    @Override
    List<Brand> getAll();

    /**
     * Получение марки авто по ID.
     *
     * @param id марки авто.
     * @return марку авто.
     */
    @Override
    Brand getByID(long id);

    /**
     * Обновить марку авто.
     *
     * @param entity марки авто.
     */
    @Override
    void update(Brand entity);

    /**
     * Удалить марку авто.
     *
     * @param entity марки авто.
     */
    @Override
    void delete(Brand entity);
}