package ru.treejoy.dao.hibernate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.treejoy.dao.BrandDAO;
import ru.treejoy.dao.ModelDAO;
import ru.treejoy.dao.daofactory.DAOFactory;
import ru.treejoy.model.brands.Brand;
import ru.treejoy.model.brands.Model;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Test HibernateModelDAO.
 */
public class HibernateModelDAOTest {
    /**
     * Логгер.
     */
    private static final Logger LOGGER = LogManager.getLogger(Logger.class.getName());

    /**
     * DAOFactory.
     */
    private static DAOFactory daoFactory;

    /**
     * ModelDAO.
     */
    private static ModelDAO modelDAO;

    /**
     * Бренд для автомобильных моделей.
     */
    private static Brand ford = new Brand();

    /**
     * Получение DAOFactory, modelDAO, создание бренда Ford.
     */
    @BeforeClass
    public static void setDAO() {
        Properties dataBaseProperties = new Properties();
        try (InputStream in = HibernateBrandDAOTest.class.getClassLoader().getResourceAsStream("app.properties")) {
            dataBaseProperties.load(in);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
        int factoryID = Integer.parseInt(dataBaseProperties.getProperty("factory"));
        daoFactory = DAOFactory.getDAOFactory(factoryID);
        modelDAO = daoFactory.getModelDAO();
        addBrand();
    }

    /**
     * Добавление бренда Ford.
     */
    private static void addBrand() {
        BrandDAO brandDAO = daoFactory.getBrandDAO();
        ford.setName("Ford");
        brandDAO.create(ford);
    }

    /**
     * Удаление Ford.
     */
    @AfterClass
    public static void clear() {
        BrandDAO brandDAO = daoFactory.getBrandDAO();
        brandDAO.delete(ford);
    }

    /**
     * Тест создания модели.
     */
    @Test
    public void create() {
        Model focus = new Model();
        focus.setName("Focus");
        focus.setBrand(ford);
        modelDAO.create(focus);
        assertThat(focus, is(modelDAO.getByID(focus.getId())));
        modelDAO.delete(focus);
    }

    /**
     * Тест получения всех моделей.
     */
    @Test
    public void getAll() {
        Model focus = new Model();
        focus.setName("Focus");
        focus.setBrand(ford);
        modelDAO.create(focus);
        Model mondeo = new Model();
        mondeo.setName("Mondeo");
        mondeo.setBrand(ford);
        modelDAO.create(mondeo);
        assertThat(Arrays.asList(focus, mondeo), is(modelDAO.getAll()));
        modelDAO.delete(focus);
        modelDAO.delete(mondeo);
    }

    /**
     * Тест обновления модели.
     */
    @Test
    public void update() {
        Model focus = new Model();
        focus.setName("Focus");
        focus.setBrand(ford);
        modelDAO.create(focus);
        focus.setName("Priora");
        modelDAO.update(focus);
        assertThat("Priora", is(modelDAO.getByID(focus.getId()).getName()));
        modelDAO.delete(focus);
    }

    /**
     * Тест удаления модели.
     */
    @Test
    public void delete() {
        Model focus = new Model();
        focus.setName("Focus");
        focus.setBrand(ford);
        modelDAO.create(focus);
        assertTrue(modelDAO.getAll().contains(focus));
        modelDAO.delete(focus);
        assertFalse(modelDAO.getAll().contains(focus));
    }
}