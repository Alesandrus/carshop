package ru.treejoy.dao.daofactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.treejoy.dao.BrandDAO;
import ru.treejoy.dao.CarAdDAO;
import ru.treejoy.dao.CityDAO;
import ru.treejoy.dao.CountryDAO;
import ru.treejoy.dao.ModelDAO;
import ru.treejoy.dao.UserDAO;

/**
 * Абстрактная ДАО-фабрика.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 30.01.2018
 */
public abstract class DAOFactory {
    /**
     * Логгер.
     */
    private static final Logger LOGGER = LogManager.getLogger(Logger.class.getName());

    /**
     * Константа для подключения к базе данных Postgres.
     */
    public static final int HIBERNATE = 1;

    /**
     * Константа для подключения к файловой системе.
     */
    public static final int FILESYSTEM = 2;

    /**
     * Получение DAO для Brand.
     *
     * @return BrandDAO.
     */
    public abstract BrandDAO getBrandDAO();

    /**
     * Получение DAO для CarAd.
     *
     * @return CarAdDAO.
     */
    public abstract CarAdDAO getCarAdDAO();

    /**
     * Получение DAO для City.
     *
     * @return CityDAO.
     */
    public abstract CityDAO getCityDAO();

    /**
     * Получение DAO для Country.
     *
     * @return CountryDAO.
     */
    public abstract CountryDAO getCountryDAO();

    /**
     * Получение DAO для Model.
     *
     * @return ModelDAO.
     */
    public abstract ModelDAO getModelDAO();

    /**
     * Получение DAO для User.
     *
     * @return UserDAO.
     */
    public abstract UserDAO getUserDAO();

    /**
     * Закрытие ресурсов.
     */
    public abstract void closeFactory();

    /**
     * Получение конкретной фабрики.
     *
     * @param whichFactory для опредения фабрики.
     * @return DAOFactory.
     */
    public static DAOFactory getDAOFactory(int whichFactory) {
        switch (whichFactory) {
            case HIBERNATE:
                return HibernateDAOFactory.getInstance();
            case FILESYSTEM:
                return FileDAOFactory.getInstance();
            default:
                return null;
        }
    }
}
