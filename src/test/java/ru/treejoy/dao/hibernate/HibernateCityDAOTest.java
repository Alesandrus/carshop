/*
package ru.treejoy.dao.hibernate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.treejoy.dao.services.CityService;
import ru.treejoy.dao.services.CountryService;
import ru.treejoy.dao.daofactory.DAOFactory;
import ru.treejoy.model.geo.City;
import ru.treejoy.model.geo.Country;

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
 * Test HibernateCityService.
 *//*

public class HibernateCityDAOTest {
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

    private static CityService cityDAO;

    */
/**
     * Бренд для автомобильных моделей.
     *//*

    private static Country usa = new Country();

    */
/**
     * Получение DAOFactory, cityDAO, добавление страны USA.
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
        cityDAO = daoFactory.getCityService();
        addCity();
    }

    */
/**
     * Добавление бренда Ford.
     *//*

    private static void addCity() {
        CountryService countryDAO = daoFactory.getCountryService();
        usa.setName("USA");
        countryDAO.create(usa);
    }

    */
/**
     * Удаление USA.
     *//*

    @AfterClass
    public static void clear() {
        CountryService countryDAO = daoFactory.getCountryService();
        countryDAO.delete(usa);
    }

    */
/**
     * Тест создания города.
     *//*

    @Test
    public void create() {
        City city = new City();
        city.setName("New York");
        city.setCountry(usa);
        cityDAO.create(city);
        assertThat(city, is(cityDAO.getByID(city.getId())));
        cityDAO.delete(city);
    }

    */
/**
     * Тест получения всех городов.
     *//*

    @Test
    public void getAll() {
        City newYork = new City();
        newYork.setName("New York");
        newYork.setCountry(usa);
        cityDAO.create(newYork);
        City lasVegas = new City();
        lasVegas.setName("Las Vegas");
        lasVegas.setCountry(usa);
        cityDAO.create(lasVegas);
        assertThat(Arrays.asList(newYork, lasVegas), is(cityDAO.getAll()));
        cityDAO.delete(newYork);
        cityDAO.delete(lasVegas);
    }

    */
/**
     * Тест обновления города.
     *//*

    @Test
    public void update() {
        City city = new City();
        city.setName("New York");
        city.setCountry(usa);
        cityDAO.create(city);
        city.setName("Las Vegas");
        cityDAO.update(city);
        assertThat("Las Vegas", is(cityDAO.getByID(city.getId()).getName()));
        cityDAO.delete(city);
    }

    */
/**
     * Тест удаления города.
     *//*

    @Test
    public void delete() {
        City city = new City();
        city.setName("New York");
        city.setCountry(usa);
        cityDAO.create(city);
        assertTrue(cityDAO.getAll().contains(city));
        cityDAO.delete(city);
        assertFalse(cityDAO.getAll().contains(city));
    }
}*/
