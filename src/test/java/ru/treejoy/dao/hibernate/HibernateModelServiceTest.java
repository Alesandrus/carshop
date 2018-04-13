/*
package ru.treejoy.dao.hibernate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.treejoy.dao.services.BrandService;
import ru.treejoy.dao.services.ModelService;
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

*/
/**
 * Test HibernateModelService.
 *//*

public class HibernateModelServiceTest {
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
     * ModelService.
     *//*

    private static ModelService modelService;

    */
/**
     * Бренд для автомобильных моделей.
     *//*

    private static Brand ford = new Brand();

    */
/**
     * Получение DAOFactory, modelService, создание бренда Ford.
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
        modelService = daoFactory.getModelService();
        addBrand();
    }

    */
/**
     * Добавление бренда Ford.
     *//*

    private static void addBrand() {
        BrandService brandService = daoFactory.getBrandService();
        ford.setName("Ford");
        brandService.create(ford);
    }

    */
/**
     * Удаление Ford.
     *//*

    @AfterClass
    public static void clear() {
        BrandService brandService = daoFactory.getBrandService();
        brandService.delete(ford);
    }

    */
/**
     * Тест создания модели.
     *//*

    @Test
    public void create() {
        Model focus = new Model();
        focus.setName("Focus");
        focus.setBrand(ford);
        modelService.create(focus);
        assertThat(focus, is(modelService.getByID(focus.getId())));
        modelService.delete(focus);
    }

    */
/**
     * Тест получения всех моделей.
     *//*

    @Test
    public void getAll() {
        Model focus = new Model();
        focus.setName("Focus");
        focus.setBrand(ford);
        modelService.create(focus);
        Model mondeo = new Model();
        mondeo.setName("Mondeo");
        mondeo.setBrand(ford);
        modelService.create(mondeo);
        assertThat(Arrays.asList(focus, mondeo), is(modelService.getAll()));
        modelService.delete(focus);
        modelService.delete(mondeo);
    }

    */
/**
     * Тест обновления модели.
     *//*

    @Test
    public void update() {
        Model focus = new Model();
        focus.setName("Focus");
        focus.setBrand(ford);
        modelService.create(focus);
        focus.setName("Priora");
        modelService.update(focus);
        assertThat("Priora", is(modelService.getByID(focus.getId()).getName()));
        modelService.delete(focus);
    }

    */
/**
     * Тест удаления модели.
     *//*

    @Test
    public void delete() {
        Model focus = new Model();
        focus.setName("Focus");
        focus.setBrand(ford);
        modelService.create(focus);
        assertTrue(modelService.getAll().contains(focus));
        modelService.delete(focus);
        assertFalse(modelService.getAll().contains(focus));
    }
}*/
