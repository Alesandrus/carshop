package ru.treejoy.dao.hibernate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import ru.treejoy.dao.BrandDAO;
import ru.treejoy.dao.daofactory.HibernateDAOFactory;
import ru.treejoy.model.brands.Brand;

import java.util.List;

/**
 * Класс DAO для CRUD операций с автомобильным брендом в базе данных.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 30.01.2018
 */
public class HibernateBrandDAO extends BrandDAO {
    /**
     * Логгер.
     */
    private static final Logger LOGGER = LogManager.getLogger(Logger.class.getName());

    /**
     * Фабрика, для получения соединения с базой данных.
     */
    private HibernateDAOFactory factory = HibernateDAOFactory.getInstance();

    /**
     * Создание автомобильного бренда в базе данных.
     *
     * @param entity автомобильный бренд.
     */
    @Override
    public void create(Brand entity) {
        Session session = factory.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Получение всех автомобильных брендов из базы данных.
     *
     * @return список автомобильных брендов.
     */
    @Override
    public List<Brand> getAll() {
        Session session = factory.getSessionFactory().openSession();
        session.beginTransaction();
        List<Brand> items = session.createQuery("from Brand").list();
        session.getTransaction().commit();
        session.close();
        return items;
    }

    /**
     * Получение автомобильного бренда из базы данных по ID.
     *
     * @param id автомобильного бренда.
     * @return автомобильный бренд.
     */
    @Override
    public Brand getByID(long id) {
        Session session = factory.getSessionFactory().openSession();
        session.beginTransaction();
        Brand item = session.get(Brand.class, id);
        session.getTransaction().commit();
        session.close();
        return item;
    }

    /**
     * Обновить автомобильный бренд в базе данных.
     *
     * @param entity автомобильный бренд.
     */
    @Override
    public void update(Brand entity) {
        Session session = factory.getSessionFactory().openSession();
        session.beginTransaction();
        Brand brandFromDB = session.get(Brand.class, entity.getId());
        brandFromDB.setName(entity.getName());
        session.update(brandFromDB);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Удалить автомобильный бренд из базы данных. Скорее всего каскадно не удалит.
     *
     * @param entity автомобильный бренд.
     */
    @Override
    public void delete(Brand entity) {
        Session session = factory.getSessionFactory().openSession();
        session.beginTransaction();
        session.remove(entity);
        session.getTransaction().commit();
        session.close();
    }
}
