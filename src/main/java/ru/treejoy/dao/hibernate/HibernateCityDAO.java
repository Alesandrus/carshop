package ru.treejoy.dao.hibernate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import ru.treejoy.dao.CityDAO;
import ru.treejoy.dao.daofactory.HibernateDAOFactory;
import ru.treejoy.model.geo.City;

import java.util.List;

/**
 * Класс DAO для CRUD операций с городом в базе данных.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 30.01.2018
 */
public class HibernateCityDAO extends CityDAO {
    /**
     * Логгер.
     */
    private static final Logger LOGGER = LogManager.getLogger(Logger.class.getName());

    /**
     * Фабрика, для получения соединения с базой данных.
     */
    private HibernateDAOFactory factory = HibernateDAOFactory.getInstance();

    /**
     * Создание города в базе данных.
     *
     * @param entity город.
     */
    @Override
    public void create(City entity) {
        Session session = factory.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Получение всех городов из базы данных.
     *
     * @return список городов.
     */
    @Override
    public List<City> getAll() {
        Session session = factory.getSessionFactory().openSession();
        session.beginTransaction();
        List<City> items = session.createQuery("from City").list();
        session.getTransaction().commit();
        session.close();
        return items;
    }

    /**
     * Получение города из базы данных по ID.
     *
     * @param id города.
     * @return город.
     */
    @Override
    public City getByID(long id) {
        Session session = factory.getSessionFactory().openSession();
        session.beginTransaction();
        City item = session.get(City.class, id);
        session.getTransaction().commit();
        session.close();
        return item;
    }

    /**
     * Обновить город в базе данных.
     *
     * @param entity город.
     */
    @Override
    public void update(City entity) {
        Session session = factory.getSessionFactory().openSession();
        session.beginTransaction();
        City cityFromDB = session.get(City.class, entity.getId());
        cityFromDB.setName(entity.getName());
        cityFromDB.setCountry(entity.getCountry());
        session.update(cityFromDB);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Удалить город из базы данных. Скорее всего каскадно не удалит.
     *
     * @param entity город.
     */
    @Override
    public void delete(City entity) {
        Session session = factory.getSessionFactory().openSession();
        session.beginTransaction();
        session.remove(entity);
        session.getTransaction().commit();
        session.close();
    }
}
