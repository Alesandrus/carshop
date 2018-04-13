package ru.treejoy.dao.services;

import ru.treejoy.model.brands.Model;

import java.util.List;

/**
 * Абстрактный класс DAO для модели автомобиля.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 31.01.2018
 */
public interface ModelService extends EntityService<Model> {
    /**
     * Создание модели авто.
     *
     * @param entity модель авто.
     */
    @Override
    void create(Model entity);

    /**
     * Получение всех моделей авто.
     *
     * @return список моделей авто.
     */
    @Override
    List<Model> getAll();

    /**
     * Получение модели авто по ID.
     *
     * @param id модели авто.
     * @return модель авто.
     */
    @Override
    Model getByID(long id);

    /**
     * Обновить модель авто.
     *
     * @param entity модели авто.
     */
    @Override
    void update(Model entity);

    /**
     * Удалить модель авто.
     *
     * @param entity модели авто.
     */
    @Override
    void delete(Model entity);

    List<Model> findAllByBrandID(long id);
}