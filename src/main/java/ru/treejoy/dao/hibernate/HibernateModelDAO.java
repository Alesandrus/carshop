package ru.treejoy.dao.hibernate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import ru.treejoy.dao.ModelDAO;
import ru.treejoy.dao.daofactory.HibernateDAOFactory;
import ru.treejoy.model.brands.Model;

import java.util.List;

/**
 * Класс DAO для CRUD операций с моделью автомобиля в базе данных.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 30.01.2018
 */
public class HibernateModelDAO extends ModelDAO {
    /**
     * Логгер.
     */
    private static final Logger LOGGER = LogManager.getLogger(Logger.class.getName());

    /**
     * Фабрика, для получения соединения с базой данных.
     */
    private HibernateDAOFactory factory = HibernateDAOFactory.getInstance();

    /**
     * Создание модели в базе данных.
     *
     * @param entity модель.
     */
    @Override
    public void create(Model entity) {
        Session session = factory.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Получение всех моделей из базы данных.
     *
     * @return список моделей.
     */
    @Override
    public List<Model> getAll() {
        Session session = factory.getSessionFactory().openSession();
        session.beginTransaction();
        List<Model> items = session.createQuery("from Model").list();
        session.getTransaction().commit();
        session.close();
        return items;
    }

    /**
     * Получение модели из базы данных по ID.
     *
     * @param id модели.
     * @return модель.
     */
    @Override
    public Model getByID(long id) {
        Session session = factory.getSessionFactory().openSession();
        session.beginTransaction();
        Model item = session.get(Model.class, id);
        session.getTransaction().commit();
        session.close();
        return item;
    }

    /**
     * Обновить модель в базе данных.
     *
     * @param entity модель.
     */
    @Override
    public void update(Model entity) {
        Session session = factory.getSessionFactory().openSession();
        session.beginTransaction();
        Model modelFromDB = session.get(Model.class, entity.getId());
        modelFromDB.setName(entity.getName());
        session.update(modelFromDB);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Удалить модель из базы данных. Скорее всего каскадно не удалит.
     *
     * @param entity модель.
     */
    @Override
    public void delete(Model entity) {
        Session session = factory.getSessionFactory().openSession();
        session.beginTransaction();
        session.remove(entity);
        session.getTransaction().commit();
        session.close();
    }
}
