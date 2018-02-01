package ru.treejoy.dao.hibernate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import ru.treejoy.dao.CountryDAO;
import ru.treejoy.dao.daofactory.HibernateDAOFactory;
import ru.treejoy.model.geo.Country;

import java.util.List;

/**
 * Класс DAO для CRUD операций со страной в базе данных.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 30.01.2018
 */
public class HibernateCountryDAO extends CountryDAO {
    /**
     * Логгер.
     */
    private static final Logger LOGGER = LogManager.getLogger(Logger.class.getName());

    /**
     * Фабрика, для получения соединения с базой данных.
     */
    private HibernateDAOFactory factory = HibernateDAOFactory.getInstance();

    /**
     * Создание страны в базе данных.
     *
     * @param entity страна.
     */
    @Override
    public void create(Country entity) {
        Session session = factory.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Получение всех стран из базы данных.
     *
     * @return список стран.
     */
    @Override
    public List<Country> getAll() {
        Session session = factory.getSessionFactory().openSession();
        session.beginTransaction();
        List<Country> items = session.createQuery("from Country").list();
        session.getTransaction().commit();
        session.close();
        return items;
    }

    /**
     * Получение стран из базы данных по ID.
     *
     * @param id страны.
     * @return страна.
     */
    @Override
    public Country getByID(long id) {
        Session session = factory.getSessionFactory().openSession();
        session.beginTransaction();
        Country item = session.get(Country.class, id);
        session.getTransaction().commit();
        session.close();
        return item;
    }

    /**
     * Обновить страну в базе данных.
     *
     * @param entity страна.
     */
    @Override
    public void update(Country entity) {
        Session session = factory.getSessionFactory().openSession();
        session.beginTransaction();
        Country countryFromDB = session.get(Country.class, entity.getId());
        countryFromDB.setName(entity.getName());
        session.update(countryFromDB);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Удалить страну из базы данных. Скорее всего каскадно не удалит.
     *
     * @param entity страна.
     */
    @Override
    public void delete(Country entity) {
        Session session = factory.getSessionFactory().openSession();
        session.beginTransaction();
        session.remove(entity);
        session.getTransaction().commit();
        session.close();
    }
}
