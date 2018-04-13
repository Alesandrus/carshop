/*
package ru.treejoy.dao.hibernate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.treejoy.dao.services.UserService;
import ru.treejoy.dao.daofactory.DAOFactory;
import ru.treejoy.model.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

*/
/**
 * Test HibernateUserService.
 *//*

public class HibernateUserDAOTest {
    */
/**
     * Логгер.
     *//*

    private static final Logger LOGGER = LogManager.getLogger(Logger.class.getName());

    */
/**
     * DAOFactory.
     *//*

    private static DAOFactory daoFactory;

    */
/**
     * UserService.
     *//*

    private static UserService userDAO;

    */
/**
     * Получение DAOFactory, userDAO.
     *//*

    @BeforeClass
    public static void setDAO() {
        Properties dataBaseProperties = new Properties();
        try (InputStream in = HibernateBrandServiceTest.class.getClassLoader().getResourceAsStream("app.properties")) {
            dataBaseProperties.load(in);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
        int factoryID = Integer.parseInt(dataBaseProperties.getProperty("factory"));
        daoFactory = DAOFactory.getDAOFactory(factoryID);
        userDAO = daoFactory.getUserService();
    }

    */
/**
     * Тест создания пользователя.
     *//*

    @Test
    public void create() {
        User user = new User();
        user.setLogin("login");
        user.setPassword("password");
        user.setName("name");
        user.setSurname("surname");
        user.setEmail("email@mail.ru");
        try {
            userDAO.create(user);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        assertThat(user, is(userDAO.getByID(user.getId())));
        userDAO.delete(user);
    }

    */
/**
     * Тест получения всех пользователей.
     *//*

    @Test
    public void getAll() {
        User firstUser = new User();
        firstUser.setLogin("login");
        firstUser.setPassword("password");
        firstUser.setName("name");
        firstUser.setSurname("surname");
        firstUser.setEmail("email@mail.ru");
        try {
            userDAO.create(firstUser);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

        User secondUser = new User();
        secondUser.setLogin("secondLogin");
        secondUser.setPassword("secondPassword");
        secondUser.setName("secondName");
        secondUser.setSurname("secondSurname");
        secondUser.setEmail("secondEmail@mail.ru");
        try {
            userDAO.create(secondUser);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

        assertThat(Arrays.asList(firstUser, secondUser), is(userDAO.getAll()));
        userDAO.delete(firstUser);
        userDAO.delete(secondUser);
    }

    */
/**
     * Тест обновления пользователя.
     *//*

    @Test
    public void update() {
        User user = new User();
        user.setLogin("login");
        user.setPassword("password");
        user.setName("name");
        user.setSurname("surname");
        user.setEmail("email@mail.ru");
        try {
            userDAO.create(user);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        user.setName("Alex");
        userDAO.update(user);
        assertThat("Alex", is(userDAO.getByID(user.getId()).getName()));
        userDAO.delete(user);
    }

    */
/**
     * Тест удаления пользователя.
     *//*

    @Test
    public void delete() {
        User user = new User();
        user.setLogin("login");
        user.setPassword("password");
        user.setName("name");
        user.setSurname("surname");
        user.setEmail("email@mail.ru");
        try {
            userDAO.create(user);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        assertTrue(userDAO.getAll().contains(user));
        userDAO.delete(user);
        assertFalse(userDAO.getAll().contains(user));
    }

    */
/**
     * Тест получения пользователя по логину и паролю.
     *//*

    @Test
    public void getByLoginAndPassword() {
        User user = new User();
        user.setLogin("login");
        user.setPassword("password");
        user.setName("name");
        user.setSurname("surname");
        user.setEmail("email@mail.ru");
        try {
            userDAO.create(user);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        assertThat(user, is(userDAO.getByLoginAndPassword("login", "password")));
        userDAO.delete(user);
    }
}*/
