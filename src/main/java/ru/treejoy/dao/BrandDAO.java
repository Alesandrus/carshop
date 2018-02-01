package ru.treejoy.dao;

import ru.treejoy.model.brands.Brand;

import java.util.List;

/**
 * Абстрактный класс DAO для марки автомобиля.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 31.01.2018
 */
public abstract class BrandDAO implements EntityDAO<Brand> {
    /**
     * Создание марки авто.
     *
     * @param entity марка авто.
     */
    @Override
    public abstract void create(Brand entity);

    /**
     * Получение всех марок авто.
     *
     * @return список марок авто.
     */
    @Override
    public abstract List<Brand> getAll();

    /**
     * Получение марки авто по ID.
     *
     * @param id марки авто.
     * @return марку авто.
     */
    @Override
    public abstract Brand getByID(long id);

    /**
     * Обновить марку авто.
     *
     * @param entity марки авто.
     */
    @Override
    public abstract void update(Brand entity);

    /**
     * Удалить марку авто.
     *
     * @param entity марки авто.
     */
    @Override
    public abstract void delete(Brand entity);
}