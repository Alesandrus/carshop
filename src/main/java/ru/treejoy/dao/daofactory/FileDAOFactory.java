package ru.treejoy.dao.daofactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.treejoy.dao.*;

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
     * @return BrandDAO.
     */
    @Override
    public BrandDAO getBrandDAO() {
        return null;
    }

    /**
     * Получение DAO для CarAd.
     *
     * @return CarAdDAO.
     */
    @Override
    public CarAdDAO getCarAdDAO() {
        return null;
    }

    /**
     * Получение DAO для City.
     *
     * @return CityDAO.
     */
    @Override
    public CityDAO getCityDAO() {
        return null;
    }

    /**
     * Получение DAO для Country.
     *
     * @return CountryDAO.
     */
    @Override
    public CountryDAO getCountryDAO() {
        return null;
    }

    /**
     * Получение DAO для Model.
     *
     * @return ModelDAO.
     */
    @Override
    public ModelDAO getModelDAO() {
        return null;
    }

    /**
     * Получение DAO для User.
     *
     * @return UserDAO.
     */
    @Override
    public UserDAO getUserDAO() {
        return null;
    }

    /**
     * Закрытие ресурсов.
     */
    @Override
    public void closeFactory() {
        //close streams
    }
}
