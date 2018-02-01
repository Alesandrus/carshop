package ru.treejoy.dao;

import ru.treejoy.model.brands.Model;

import java.util.List;

/**
 * Абстрактный класс DAO для модели автомобиля.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 31.01.2018
 */
public abstract class ModelDAO implements EntityDAO<Model> {
    /**
     * Создание модели авто.
     *
     * @param entity модель авто.
     */
    @Override
    public abstract void create(Model entity);

    /**
     * Получение всех моделей авто.
     *
     * @return список моделей авто.
     */
    @Override
    public abstract List<Model> getAll();

    /**
     * Получение модели авто по ID.
     *
     * @param id модели авто.
     * @return модель авто.
     */
    @Override
    public abstract Model getByID(long id);

    /**
     * Обновить модель авто.
     *
     * @param entity модели авто.
     */
    @Override
    public abstract void update(Model entity);

    /**
     * Удалить модель авто.
     *
     * @param entity модели авто.
     */
    @Override
    public abstract void delete(Model entity);
}