package ru.treejoy.dao.hibernate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import ru.treejoy.dao.UserDAO;
import ru.treejoy.dao.daofactory.HibernateDAOFactory;
import ru.treejoy.exceptions.CreateEmailException;
import ru.treejoy.exceptions.CreateLoginException;
import ru.treejoy.model.User;

import javax.persistence.Query;
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
    public void create(User entity) throws CreateLoginException, CreateEmailException {
        Session session = factory.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("SELECT u from User u WHERE login=:login OR email=:email");
        query.setParameter("login", entity.getLogin());
        query.setParameter("email", entity.getEmail());
        List<User> users = query.getResultList();
        for (User user : users) {
            if (user.getLogin().equals(entity.getLogin())) {
                session.getTransaction().commit();
                session.close();
                throw new CreateLoginException();
            }
            if (user.getEmail().equals(entity.getEmail())) {
                session.getTransaction().commit();
                session.close();
                throw new CreateEmailException();
            }
        }
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

    /**
     * Получение пользователя по логину и паролю.
     *
     * @param login    логин.
     * @param password пароль.
     * @return пользователя.
     */
    @Override
    public User getByLoginAndPassword(String login, String password) {
        Session session = factory.getSessionFactory().openSession();
        session.beginTransaction();
        List users = session
                .createQuery(String.format("from User where login='%s' and password='%s'", login, password))
                .getResultList();
        User user = null;
        if (!users.isEmpty()) {
            user = (User) users.get(0);
        }
        session.getTransaction().commit();
        session.close();
        return user;
    }
}
