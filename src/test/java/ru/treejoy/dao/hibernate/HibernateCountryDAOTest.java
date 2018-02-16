package ru.treejoy.dao.hibernate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.treejoy.dao.CityDAO;
import ru.treejoy.dao.CountryDAO;
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

/**
 * Test HibernateCountryDAO.
 */
public class HibernateCountryDAOTest {
    /**
     * Логгер.
     */
    private static final Logger LOGGER = LogManager.getLogger(Logger.class.getName());

    /**
     * DAOFactory.
     */
    private static DAOFactory daoFactory;

    /**
     * CountryDAO.
     */
    private static CountryDAO countryDAO;

    /**
     * CityDAO.
     */
    private static CityDAO cityDAO;

    /**
     * Получение DAOFactory, countryDAO, cityDAO.
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
        countryDAO = daoFactory.getCountryDAO();
        cityDAO = daoFactory.getCityDAO();
    }

    /**
     * Тест создания страны.
     */
    @Test
    public void create() {
        Country usa = new Country();
        usa.setName("USA");
        countryDAO.create(usa);
        assertThat(usa, is(countryDAO.getByID(usa.getId())));
        countryDAO.delete(usa);
    }

    /**
     * Тест получения всех стран.
     */
    @Test
    public void getAll() {
        Country usa = new Country();
        usa.setName("USA");
        countryDAO.create(usa);

        Country germany = new Country();
        germany.setName("Germany");
        countryDAO.create(germany);

        assertThat(Arrays.asList(usa, germany), is(countryDAO.getAll()));
        countryDAO.delete(usa);
        countryDAO.delete(germany);
    }

    /**
     * Тест обновления страны.
     */
    @Test
    public void update() {
        Country usa = new Country();
        usa.setName("USA");
        countryDAO.create(usa);
        usa.setName("Nigeria");
        countryDAO.update(usa);
        assertThat("Nigeria", is(countryDAO.getByID(usa.getId()).getName()));
        countryDAO.delete(usa);
    }

    /**
     * Тест удаления страны.
     */
    @Test
    public void delete() {
        Country usa = new Country();
        usa.setName("USA");
        countryDAO.create(usa);
        assertTrue(countryDAO.getAll().contains(usa));
        countryDAO.delete(usa);
        assertFalse(countryDAO.getAll().contains(usa));
    }

    /**
     * Тест получения всех городов одной страны.
     */
    @Test
    public void getCities() {
        Country usa = new Country();
        usa.setName("USA");
        countryDAO.create(usa);

        City chikago = new City();
        chikago.setName("Chicago");
        chikago.setCountry(usa);
        cityDAO.create(chikago);

        City vashington = new City();
        vashington.setName("Vashington");
        vashington.setCountry(usa);
        cityDAO.create(vashington);
        assertThat(Arrays.asList(chikago, vashington), is(countryDAO.getCities(usa.getId())));
        cityDAO.delete(chikago);
        cityDAO.delete(vashington);
        countryDAO.delete(usa);
    }
}