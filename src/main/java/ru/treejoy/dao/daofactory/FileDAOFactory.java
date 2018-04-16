package ru.treejoy.dao.daofactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.treejoy.dao.services.BrandService;
import ru.treejoy.dao.services.CarAdService;
import ru.treejoy.dao.services.CityService;
import ru.treejoy.dao.services.CountryService;
import ru.treejoy.dao.services.ModelService;
import ru.treejoy.dao.services.UserService;

/**
 * DAO-factory for file system (not realized).
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 25.12.2017
 */
public class FileDAOFactory extends DAOFactory {
    /**
     * Logger.
     */
    private static final Logger LOGGER = LogManager.getLogger(Logger.class.getName());

    /**
     * Singleton.
     */
    private static final FileDAOFactory FACTORY = new FileDAOFactory();

    /**
     * Private constructor.
     */
    private FileDAOFactory() {
    }

    /**
     * Getting singleton.
     *
     * @return FileDAOFactory.
     */
    public static FileDAOFactory getInstance() {
        return FACTORY;
    }

    /**
     * Getting BrandService.
     *
     * @return BrandService.
     */
    @Override
    public BrandService getBrandService() {
        return null;
    }

    /**
     * Getting CarAdService.
     *
     * @return CarAdService.
     */
    @Override
    public CarAdService getCarAdService() {
        return null;
    }

    /**
     * Getting CityService.
     *
     * @return CityService.
     */
    @Override
    public CityService getCityService() {
        return null;
    }

    /**
     * Getting CountryService.
     *
     * @return CountryService.
     */
    @Override
    public CountryService getCountryService() {
        return null;
    }

    /**
     * Getting ModelService.
     *
     * @return ModelService.
     */
    @Override
    public ModelService getModelService() {
        return null;
    }

    /**
     * Getting UserService.
     *
     * @return UserService.
     */
    @Override
    public UserService getUserService() {
        return null;
    }
}
