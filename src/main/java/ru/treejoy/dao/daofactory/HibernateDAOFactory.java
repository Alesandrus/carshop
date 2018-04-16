package ru.treejoy.dao.daofactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import ru.treejoy.dao.services.BrandService;
import ru.treejoy.dao.services.CarAdService;
import ru.treejoy.dao.services.CityService;
import ru.treejoy.dao.services.CountryService;
import ru.treejoy.dao.services.ModelService;
import ru.treejoy.dao.services.UserService;

/**
 * DAO-Factory for Hibernate.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 30.01.2018
 */
public class HibernateDAOFactory extends DAOFactory {
    /**
     * Logger.
     */
    private static final Logger LOGGER = LogManager.getLogger(Logger.class.getName());

    /**
     * Singleton for class.
     */
    private static final HibernateDAOFactory FACTORY = new HibernateDAOFactory();

    /**
     * BrandService.
     */
    @Autowired
    @Qualifier("brandService")
    private BrandService hibernateBrandService;

    /**
     * ModelService.
     */
    @Autowired
    @Qualifier("modelService")
    private ModelService modelService;

    /**
     * CityService.
     */
    @Autowired
    @Qualifier("cityService")
    private CityService cityService;

    /**
     * CountryService.
     */
    @Autowired
    @Qualifier("countryService")
    private CountryService countryService;

    /**
     * UserService.
     */
    @Autowired
    @Qualifier("userService")
    private UserService userService;

    /**
     * CarAdService.
     */
    @Autowired
    @Qualifier("carAdService")
    private CarAdService carAdService;

    /**
     * Private constructor.
     */
    private HibernateDAOFactory() {
    }

    /**
     * Getting singleton instance.
     *
     * @return HibernateDAOFactory.
     */
    public static HibernateDAOFactory getInstance() {
        return FACTORY;
    }

    /**
     * Getting BrandService.
     *
     * @return BrandService.
     */
    @Override
    public BrandService getBrandService() {
        return hibernateBrandService;
    }

    /**
     * Getting CarAdService.
     *
     * @return CarAdService.
     */
    @Override
    public CarAdService getCarAdService() {
        return carAdService;
    }

    /**
     * Getting CityService.
     *
     * @return CityService.
     */
    @Override
    public CityService getCityService() {
        return cityService;
    }

    /**
     * Getting CountryService.
     *
     * @return CountryService.
     */
    @Override
    public CountryService getCountryService() {
        return countryService;
    }

    /**
     * Getting ModelService.
     *
     * @return ModelService.
     */
    @Override
    public ModelService getModelService() {
        return modelService;
    }

    /**
     * Getting UserService.
     *
     * @return UserService.
     */
    @Override
    public UserService getUserService() {
        return userService;
    }
}
