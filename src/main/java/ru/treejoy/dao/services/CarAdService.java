package ru.treejoy.dao.services;

import ru.treejoy.model.ad.CarAd;

import java.util.List;

/**
 * Service for car ad.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 10.04.2018
 */
public interface CarAdService extends EntityService<CarAd> {
    /**
     * Saves car ad.
     *
     * @param entity car ad.
     */
    @Override
    void create(CarAd entity);

    /**
     * Get all car ads.
     *
     * @return list of car ads.
     */
    @Override
    List<CarAd> getAll();

    /**
     * Get car ad by ID.
     *
     * @param id car ad.
     * @return car ad.
     */
    @Override
    CarAd getByID(long id);

    /**
     * Update car ad.
     *
     * @param entity car ad.
     */
    @Override
    void update(CarAd entity);

    /**
     * Delete car ad.
     *
     * @param entity for removing.
     */
    @Override
    void delete(CarAd entity);

    /**
     * Update status sale.
     *
     * @param id car ad's.
     * @param status true if car is sold.
     */
    void updateStatus(long id, boolean status);

    /**
     * Get all car ads by user.
     *
     * @param id user's.
     * @return list of car ads.
     */
    List<CarAd> getAllByUserId(long id);

    /**
     * Get all car ads by brand, model, presence photo or posted today.
     *
     * @param brandID      ID brand's.
     * @param modelID      ID model's.
     * @param onlyWithFoto true if presence photo.
     * @param today        true if posted today.
     * @return list of car ads.
     */
    List<CarAd> getAllFromFilter(long brandID, long modelID, boolean onlyWithFoto, boolean today);
}