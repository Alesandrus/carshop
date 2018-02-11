package ru.treejoy.dao;

import ru.treejoy.model.ad.CarAd;

import java.util.List;

/**
 * Абстрактный класс DAO для объявления о продаже авто.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 31.01.2018
 */
public abstract class CarAdDAO implements EntityDAO<CarAd> {
    /**
     * Создание объявления о продаже авто.
     *
     * @param entity объявление о продаже авто.
     */
    @Override
    public abstract void create(CarAd entity);

    /**
     * Получение всех объявлений о продаже авто.
     *
     * @return список объявлений о продаже авто.
     */
    @Override
    public abstract List<CarAd> getAll();

    /**
     * Получение объявления о продаже авто по ID.
     *
     * @param id объявления о продаже авто.
     * @return объявление о продаже авто.
     */
    @Override
    public abstract CarAd getByID(long id);

    /**
     * Обновить объявление о продаже авто.
     *
     * @param entity объявление о продаже авто.
     */
    @Override
    public abstract void update(CarAd entity);

    /**
     * Удалить объявление о продаже авто.
     *
     * @param entity объявление о продаже авто.
     */
    @Override
    public abstract void delete(CarAd entity);

    /**
     * Обновить статус объявления о продаже авто.
     *
     * @param id     объявление о продаже авто.
     * @param status объявления.
     */
    public abstract void updateStatus(long id, boolean status);

    /**
     * Получить все объявления одного пользователя.
     *
     * @param id пользователя.
     * @return список объявлений.
     */
    public abstract List<CarAd> getAllById(long id);
}