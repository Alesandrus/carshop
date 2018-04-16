package ru.treejoy.dao.daofactory;

import ru.treejoy.dao.services.BrandService;
import ru.treejoy.dao.services.CarAdService;
import ru.treejoy.dao.services.CityService;
import ru.treejoy.dao.services.CountryService;
import ru.treejoy.dao.services.ModelService;
import ru.treejoy.dao.services.UserService;

/**
 * Abstract DAO-factory.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 30.01.2018
 */
public abstract class DAOFactory {

    /**
     * Getting BrandService.
     *
     * @return BrandService.
     */
    public abstract BrandService getBrandService();

    /**
     * Getting CarAdService.
     *
     * @return CarAdService.
     */
    public abstract CarAdService getCarAdService();

    /**
     * Getting CityService.
     *
     * @return CityService.
     */
    public abstract CityService getCityService();

    /**
     * Getting CountryService.
     *
     * @return CountryService.
     */
    public abstract CountryService getCountryService();

    /**
     * Getting ModelService.
     *
     * @return ModelService.
     */
    public abstract ModelService getModelService();

    /**
     * Getting UserService.
     *
     * @return UserService.
     */
    public abstract UserService getUserService();
}
