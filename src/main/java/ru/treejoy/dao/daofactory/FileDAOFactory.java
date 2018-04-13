package ru.treejoy.dao.daofactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.treejoy.dao.services.*;

/**
 * ДАО-фабрика для работы с файловой системой.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 25.12.2017
 */
public class FileDAOFactory extends DAOFactory {
    /**
     * Логгер.
     */
    private static final Logger LOGGER = LogManager.getLogger(Logger.class.getName());

    /**
     * Синглтон-переменная.
     */
    private static final FileDAOFactory FACTORY = new FileDAOFactory();

    /**
     * Приватный конструктор.
     */
    private FileDAOFactory() {
    }

    /**
     * Получение экземпляра фабрики.
     *
     * @return FileDAOFactory.
     */
    public static FileDAOFactory getInstance() {
        return FACTORY;
    }

    /**
     * Получение DAO для Brand.
     *
     * @return BrandService.
     */
    @Override
    public BrandService getBrandService() {
        return null;
    }

    /**
     * Получение DAO для CarAd.
     *
     * @return CarAdService.
     */
    @Override
    public CarAdService getCarAdService() {
        return null;
    }

    /**
     * Получение DAO для City.
     *
     * @return CityService.
     */
    @Override
    public CityService getCityService() {
        return null;
    }

    /**
     * Получение DAO для Country.
     *
     * @return CountryService.
     */
    @Override
    public CountryService getCountryService() {
        return null;
    }

    /**
     * Получение DAO для Model.
     *
     * @return ModelService.
     */
    @Override
    public ModelService getModelService() {
        return null;
    }

    /**
     * Получение DAO для User.
     *
     * @return UserService.
     */
    @Override
    public UserService getUserService() {
        return null;
    }
}
