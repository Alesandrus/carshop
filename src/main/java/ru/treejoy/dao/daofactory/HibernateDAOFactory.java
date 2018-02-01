package ru.treejoy.dao.daofactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.treejoy.dao.hibernate.HibernateBrandDAO;
import ru.treejoy.dao.hibernate.HibernateCarAdDAO;
import ru.treejoy.dao.hibernate.HibernateCityDAO;
import ru.treejoy.dao.hibernate.HibernateCountryDAO;
import ru.treejoy.dao.hibernate.HibernateModelDAO;
import ru.treejoy.dao.hibernate.HibernateUserDAO;

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
     * Фабрика сессий Hibernate.
     */
    private SessionFactory sessionFactory;

    /**
     * Синглтон текущего класса.
     */
    private static final HibernateDAOFactory FACTORY = new HibernateDAOFactory();

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
     * Конфигурирование hibernate, подключение к бд.
     */
    private void config() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    /**
     * Получение SessionFactory.
     *
     * @return SessionFactory.
     */
    public SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            config();
        }
        return sessionFactory;
    }

    /**
     * Получение DAO для HibernateBrand.
     *
     * @return HibernateBrandDAO.
     */
    @Override
    public HibernateBrandDAO getBrandDAO() {
        return new HibernateBrandDAO();
    }

    /**
     * Получение DAO для HibernateCarAd.
     *
     * @return HibernateCarAdDAO.
     */
    @Override
    public HibernateCarAdDAO getCarAdDAO() {
        return new HibernateCarAdDAO();
    }

    /**
     * Получение DAO для HibernateCity.
     *
     * @return HibernateCityAdDAO.
     */
    @Override
    public HibernateCityDAO getCityDAO() {
        return new HibernateCityDAO();
    }

    /**
     * Получение DAO для HibernateCountry.
     *
     * @return HibernateCountryDAO.
     */
    @Override
    public HibernateCountryDAO getCountryDAO() {
        return new HibernateCountryDAO();
    }

    /**
     * Получение DAO для HibernateModel.
     *
     * @return HibernateModelDAO.
     */
    @Override
    public HibernateModelDAO getModelDAO() {
        return new HibernateModelDAO();
    }

    /**
     * Получение DAO для HibernateUser.
     *
     * @return HibernateUserDAO.
     */
    @Override
    public HibernateUserDAO getUserDAO() {
        return new HibernateUserDAO();
    }

    /**
     * Вызов метода disconnectDB() для завкрытия соединения.
     */
    @Override
    public void closeFactory() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
