package ru.treejoy.dao.hibernate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import ru.treejoy.dao.UserDAO;
import ru.treejoy.dao.daofactory.HibernateDAOFactory;
import ru.treejoy.model.User;

import java.util.List;

/**
 * Класс DAO для CRUD операций с пользователем в базе данных.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 30.01.2018
 */
public class HibernateUserDAO extends UserDAO {
    /**
     * Логгер.
     */
    private static final Logger LOGGER = LogManager.getLogger(Logger.class.getName());

    /**
     * Фабрика, для получения соединения с базой данных.
     */
    private HibernateDAOFactory factory = HibernateDAOFactory.getInstance();

    /**
     * Создание пользователя в базе данных.
     *
     * @param entity пользователь.
     */
    @Override
    public void create(User entity) {
        Session session = factory.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Получение всех пользователей из базы данных.
     *
     * @return список пользователей.
     */
    @Override
    public List<User> getAll() {
        Session session = factory.getSessionFactory().openSession();
        session.beginTransaction();
        List<User> items = session.createQuery("from User").list();
        session.getTransaction().commit();
        session.close();
        return items;
    }

    /**
     * Получение пользователя из базы данных по ID.
     *
     * @param id пользователя.
     * @return пользователя.
     */
    @Override
    public User getByID(long id) {
        Session session = factory.getSessionFactory().openSession();
        session.beginTransaction();
        User item = session.get(User.class, id);
        session.getTransaction().commit();
        session.close();
        return item;
    }

    /**
     * Обновить пользователя в базе данных.
     *
     * @param entity пользователь.
     */
    @Override
    public void update(User entity) {
        Session session = factory.getSessionFactory().openSession();
        session.beginTransaction();
        User userFromDB = session.get(User.class, entity.getId());
        userFromDB.setName(entity.getName());
        userFromDB.setEmail(entity.getEmail());
        userFromDB.setSurname(entity.getSurname());
        session.update(userFromDB);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Удалить пользователя из базы данных. Скорее всего каскадно не удалит.
     *
     * @param entity пользователь.
     */
    @Override
    public void delete(User entity) {
        Session session = factory.getSessionFactory().openSession();
        session.beginTransaction();
        session.remove(entity);
        session.getTransaction().commit();
        session.close();
    }
}