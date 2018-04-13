package ru.treejoy.dao.daofactory;

import ru.treejoy.dao.services.*;

/**
 * Абстрактная ДАО-фабрика.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 30.01.2018
 */
public abstract class DAOFactory {

    /**
     * Получение DAO для Brand.
     *
     * @return BrandService.
     */
    public abstract BrandService getBrandService();

    /**
     * Получение DAO для CarAd.
     *
     * @return CarAdService.
     */
    public abstract CarAdService getCarAdService();

    /**
     * Получение DAO для City.
     *
     * @return CityService.
     */
    public abstract CityService getCityService();

    /**
     * Получение DAO для Country.
     *
     * @return CountryService.
     */
    public abstract CountryService getCountryService();

    /**
     * Получение DAO для Model.
     *
     * @return ModelService.
     */
    public abstract ModelService getModelService();

    /**
     * Получение DAO для User.
     *
     * @return UserService.
     */
    public abstract UserService getUserService();
}
