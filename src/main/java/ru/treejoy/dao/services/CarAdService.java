package ru.treejoy.dao.services;

import ru.treejoy.model.ad.CarAd;

import java.util.List;

/**
 * Абстрактный класс DAO для объявления о продаже авто.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 31.01.2018
 */
public interface CarAdService extends EntityService<CarAd> {
    /**
     * Создание объявления о продаже авто.
     *
     * @param entity объявление о продаже авто.
     */
    @Override
    void create(CarAd entity);

    /**
     * Получение всех объявлений о продаже авто.
     *
     * @return список объявлений о продаже авто.
     */
    @Override
    List<CarAd> getAll();

    /**
     * Получение объявления о продаже авто по ID.
     *
     * @param id объявления о продаже авто.
     * @return объявление о продаже авто.
     */
    @Override
    CarAd getByID(long id);

    /**
     * Обновить объявление о продаже авто.
     *
     * @param entity объявление о продаже авто.
     */
    @Override
    void update(CarAd entity);

    /**
     * Удалить объявление о продаже авто.
     *
     * @param entity объявление о продаже авто.
     */
    @Override
    void delete(CarAd entity);

    /**
     * Обновить статус объявления о продаже авто.
     *
     * @param id     объявление о продаже авто.
     * @param status объявления.
     */
    void updateStatus(long id, boolean status);

    /**
     * Получить все объявления одного пользователя.
     *
     * @param id пользователя.
     * @return список объявлений.
     */
    List<CarAd> getAllByUserId(long id);

    /**
     * Получить список объявлений, удовлетворяющих условиям.
     *
     * @param brandID      ID бренда.
     * @param modelID      ID модели.
     * @param onlyWithFoto только с фото.
     * @param today        за сегодня.
     * @return список объявлений.
     */
    List<CarAd> getAllFromFilter(long brandID, long modelID, boolean onlyWithFoto, boolean today);
}