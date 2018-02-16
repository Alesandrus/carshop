package ru.treejoy.dao.hibernate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import ru.treejoy.dao.BrandDAO;
import ru.treejoy.dao.ModelDAO;
import ru.treejoy.dao.daofactory.DAOFactory;
import ru.treejoy.model.brands.Brand;
import ru.treejoy.model.brands.Model;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Test HibernateBrandDAO.
 */
public class HibernateBrandDAOTest {
    /**
     * Логгер.
     */
    private static final Logger LOGGER = LogManager.getLogger(Logger.class.getName());

    /**
     * DAOFactory.
     */
    private static DAOFactory daoFactory;

    /**
     * BrandDAO.
     */
    private static BrandDAO brandDAO;

    /**
     * ModelDAO.
     */
    private static ModelDAO modelDAO;

    /**
     * Получение DAOFactory, brandDAO, modelDAO.
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
        brandDAO = daoFactory.getBrandDAO();
        modelDAO = daoFactory.getModelDAO();
    }

    /**
     * Тест создания бренда.
     */
    @org.junit.Test
    public void create() {
        Brand brand = new Brand();
        brand.setName("Ford");
        brandDAO.create(brand);
        assertThat(brand, is(brandDAO.getByID(brand.getId())));
        brandDAO.delete(brand);
    }

    /**
     * Тест получения всех брендов.
     */
    @org.junit.Test
    public void getAll() {
        Brand ford = new Brand();
        ford.setName("Ford");
        brandDAO.create(ford);
        Brand bmw = new Brand();
        bmw.setName("BMW");
        brandDAO.create(bmw);
        List<Brand> brands = Arrays.asList(ford, bmw);
        assertThat(brands, is(brandDAO.getAll()));
        brandDAO.delete(ford);
        brandDAO.delete(bmw);
    }

    /**
     * Тест обновления бренда.
     */
    @org.junit.Test
    public void update() {
        Brand brand = new Brand();
        brand.setName("Ford");
        brandDAO.create(brand);
        brand.setName("BMW");
        brandDAO.update(brand);
        assertThat("BMW", is(brandDAO.getByID(brand.getId()).getName()));
        brandDAO.delete(brand);
    }

    /**
     * Тест удаления бренда.
     */
    @org.junit.Test
    public void delete() {
        Brand ford = new Brand();
        ford.setName("Ford");
        brandDAO.create(ford);
        assertTrue(brandDAO.getAll().contains(ford));
        brandDAO.delete(ford);
        assertFalse(brandDAO.getAll().contains(ford));
    }

    /**
     * Тест получения всех моделей одного бренда.
     */
    @org.junit.Test
    public void getModels() {
        Brand ford = new Brand();
        ford.setName("Ford");
        brandDAO.create(ford);

        Model focus = new Model();
        focus.setName("Focus");
        focus.setBrand(ford);
        modelDAO.create(focus);

        Model mondeo = new Model();
        mondeo.setName("Mondeo");
        mondeo.setBrand(ford);
        modelDAO.create(mondeo);

        List<Model> models = Arrays.asList(focus, mondeo);
        assertThat(models, is(brandDAO.getModels(ford.getId())));
        modelDAO.delete(mondeo);
        modelDAO.delete(focus);
        brandDAO.delete(ford);
    }
}