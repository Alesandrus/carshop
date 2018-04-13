package ru.treejoy.dao.daofactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import ru.treejoy.dao.hibernate.*;
import ru.treejoy.dao.services.*;

/**
 * ДАО-фабрика для работы с базой данных с помощью Hibernate.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 30.01.2018
 */
public class HibernateDAOFactory extends DAOFactory {
    /**
     * Логгер.
     */
    private static final Logger LOGGER = LogManager.getLogger(Logger.class.getName());

    /**
     * Синглтон текущего класса.
     */
    private static final HibernateDAOFactory FACTORY = new HibernateDAOFactory();

    @Autowired
    @Qualifier("brandService")
    private BrandService hibernateBrandService;

    @Autowired
    @Qualifier("modelService")
    private ModelService modelService;

    @Autowired
    @Qualifier("cityService")
    private CityService cityService;

    @Autowired
    @Qualifier("countryService")
    private CountryService countryService;

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @Autowired
    @Qualifier("carAdService")
    private CarAdService carAdService;

    /**
     * Приватный конструктор.
     */
    private HibernateDAOFactory() {
    }

    /**
     * Получение экземпляра фабрики.
     *
     * @return HibernateDAOFactory.
     */
    public static HibernateDAOFactory getInstance() {
        return FACTORY;
    }

    /**
     * Получение DAO для HibernateBrand.
     *
     * @return HibernateBrandService.
     */
    @Override
    public BrandService getBrandService() {
        return hibernateBrandService;
    }

    /**
     * Получение DAO для HibernateCarAd.
     *
     * @return HibernateCarAdService.
     */
    @Override
    public CarAdService getCarAdService() {
        return carAdService;
    }

    /**
     * Получение DAO для HibernateCity.
     *
     * @return HibernateCityAdDAO.
     */
    @Override
    public CityService getCityService() {
        return cityService;
    }

    /**
     * Получение DAO для HibernateCountry.
     *
     * @return HibernateCountryService.
     */
    @Override
    public CountryService getCountryService() {
        return countryService;
    }

    /**
     * Получение DAO для HibernateModel.
     *
     * @return HibernateModelService.
     */
    @Override
    public ModelService getModelService() {
        return modelService;
    }

    /**
     * Получение DAO для HibernateUser.
     *
     * @return HibernateUserService.
     */
    @Override
    public UserService getUserService() {
        return userService;
    }
}
