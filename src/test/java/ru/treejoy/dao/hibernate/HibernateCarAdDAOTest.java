/*
package ru.treejoy.dao.hibernate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.treejoy.dao.services.*;
import ru.treejoy.dao.daofactory.DAOFactory;
import ru.treejoy.model.User;
import ru.treejoy.model.ad.CarAd;
import ru.treejoy.model.brands.Brand;
import ru.treejoy.model.brands.Model;
import ru.treejoy.model.geo.City;
import ru.treejoy.model.geo.Country;
import ru.treejoy.model.parts.Body;
import ru.treejoy.model.parts.Motor;
import ru.treejoy.model.parts.Transmission;
import ru.treejoy.model.parts.WheelDrive;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

*/
/**
 * Test HibernateCarAdService.
 *//*

public class HibernateCarAdDAOTest {
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
     * CarAdService.
     *//*

    private static CarAdService carAdDAO;

    */
/**
     * Brand Ford.
     *//*

    private static Brand ford = new Brand();

    */
/**
     * Brand Toyota.
     *//*

    private static Brand toyota = new Brand();

    */
/**
     * Model Focus.
     *//*

    private static Model focus = new Model();

    */
/**
     * Model Mondeo.
     *//*

    private static Model mondeo = new Model();

    */
/**
     * Model Camry.
     *//*

    private static Model camry = new Model();

    */
/**
     * Country USA.
     *//*

    private static Country usa = new Country();

    */
/**
     * City Los Angeles.
     *//*

    private static City losAngeles = new City();

    */
/**
     * User creator.
     *//*

    private static User user = new User();

    */
/**
     * CarAd for Camry.
     *//*

    private static CarAd camryAd = new CarAd();

    */
/**
     * Получение DAOFactory, carAdDAO, заполнение брендов, моделей, создание пользователя, добавление объявления.
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
        carAdDAO = daoFactory.getCarAdService();
        createBrandAndModel();
        createCountryAndCity();
        createUser();
        createSomeAdds();
    }

    */
/**
     * Заполнение брендов и моделей.
     *//*

    private static void createBrandAndModel() {
        BrandService brandService = daoFactory.getBrandService();
        ford.setName("Ford");
        brandService.create(ford);
        toyota.setName("Toyota");
        brandService.create(toyota);
        ModelService modelService = daoFactory.getModelService();
        focus.setName("Focus");
        focus.setBrand(ford);
        modelService.create(focus);
        mondeo.setName("Mondeo");
        mondeo.setBrand(ford);
        modelService.create(mondeo);
        camry.setName("Camry");
        camry.setBrand(toyota);
        modelService.create(camry);
    }

    */
/**
     * Удаление брендов и моделей.
     *//*

    private static void deleteBrandAndModel() {
        ModelService modelService = daoFactory.getModelService();
        modelService.delete(camry);
        modelService.delete(mondeo);
        modelService.delete(focus);
        BrandService brandService = daoFactory.getBrandService();
        brandService.delete(ford);
        brandService.delete(toyota);
    }

    */
/**
     * Заполнение стран и городов.
     *//*

    private static void createCountryAndCity() {
        CountryService countryDAO = daoFactory.getCountryService();
        usa.setName("USA");
        countryDAO.create(usa);
        CityService cityDAO = daoFactory.getCityService();
        losAngeles.setName("Los Angeles");
        losAngeles.setCountry(usa);
        cityDAO.create(losAngeles);
    }

    */
/**
     * Удаление стран и городов.
     *//*

    private static void deleteCountryAndCity() {
        CityService cityDAO = daoFactory.getCityService();
        cityDAO.delete(losAngeles);
        CountryService countryDAO = daoFactory.getCountryService();
        countryDAO.delete(usa);
    }

    */
/**
     * Создание пользователя.
     *//*

    private static void createUser() {
        UserService userDAO = daoFactory.getUserService();
        user.setLogin("login");
        user.setPassword("password");
        user.setName("Name");
        user.setSurname("Surname");
        user.setEmail("email@mail.com");
        try {
            userDAO.create(user);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    */
/**
     * Удаление пользователя.
     *//*

    private static void deleteUser() {
        UserService userDAO = daoFactory.getUserService();
        userDAO.delete(user);
    }

    */
/**
     * Добавление объявления.
     *//*

    private static void createSomeAdds() {
        camryAd.setModel(camry);
        camryAd.setCity(losAngeles);
        camryAd.setCreator(user);
        camryAd.setStatus(false);
        camryAd.setPower(200);
        camryAd.setKilometrage(50000);
        camryAd.setYearOfManufacture(2015);
        camryAd.setPrice(BigInteger.valueOf(700_000));
        camryAd.setBody(Body.SEDAN);
        camryAd.setWheelDrive(WheelDrive.FRONT);
        camryAd.setMotor(Motor.GASOLINE);
        camryAd.setTransmission(Transmission.AUTOMATIC);
        camryAd.setDescription("Description and etc.");
        carAdDAO.create(camryAd);
    }

    */
/**
     * Удаление объявления.
     *//*

    private static void deleteSomeAdds() {
        carAdDAO.delete(camryAd);
    }

    */
/**
     * Метод по установке параметров объявления.
     *
     * @param carAd объявления.
     *//*

    private void setCarAd(CarAd carAd) {
        carAd.setModel(focus);
        carAd.setCity(losAngeles);
        carAd.setCreator(user);
        carAd.setStatus(false);
        carAd.setPower(100);
        carAd.setKilometrage(1000);
        carAd.setYearOfManufacture(2000);
        carAd.setPrice(BigInteger.valueOf(500_000));
        carAd.setBody(Body.COUPE);
        carAd.setWheelDrive(WheelDrive.FRONT);
        carAd.setMotor(Motor.DIESEL);
        carAd.setTransmission(Transmission.AUTOMATIC);
        carAd.setDescription("Description and etc.");
        carAd.setImages(Arrays.asList("Image1", "Image2"));
    }

    */
/**
     * Очистка таблиц.
     *//*

    @AfterClass
    public static void clear() {
        deleteSomeAdds();
        deleteBrandAndModel();
        deleteCountryAndCity();
        deleteUser();
    }

    */
/**
     * Тест создания объявления.
     *//*

    @Test
    public void create() {
        CarAd carAd = new CarAd();
        setCarAd(carAd);
        carAdDAO.create(carAd);
        assertThat(carAd, is(carAdDAO.getByID(carAd.getId())));
        carAdDAO.delete(carAd);
    }

    */
/**
     * Тест получения всех объявлений.
     *//*

    @Test
    public void getAll() {
        CarAd carAd = new CarAd();
        setCarAd(carAd);
        carAdDAO.create(carAd);
        assertThat(Arrays.asList(camryAd, carAd), is(carAdDAO.getAll()));
        carAdDAO.delete(carAd);
    }

    */
/**
     * Тест обновления объявления.
     *//*

    @Test
    public void update() {
        CarAd carAd = new CarAd();
        setCarAd(carAd);
        carAdDAO.create(carAd);
        assertThat(carAd.getPrice(), is(carAdDAO.getByID(carAd.getId()).getPrice()));
        carAd.setPrice(BigInteger.valueOf(450_000));
        carAdDAO.update(carAd);
        assertThat(BigInteger.valueOf(450_000), is(carAdDAO.getByID(carAd.getId()).getPrice()));
        carAdDAO.delete(carAd);
    }

    */
/**
     * Тест удаления объявления.
     *//*

    @Test
    public void delete() {
        CarAd carAd = new CarAd();
        setCarAd(carAd);
        carAdDAO.create(carAd);
        assertTrue(carAdDAO.getAll().contains(carAd));
        carAdDAO.delete(carAd);
        assertFalse(carAdDAO.getAll().contains(carAd));
    }

    */
/**
     * Тест обновления статуса продажи объявления.
     *//*

    @Test
    public void updateStatus() {
        CarAd carAd = new CarAd();
        setCarAd(carAd);
        carAdDAO.create(carAd);
        assertFalse(carAdDAO.getByID(carAd.getId()).isStatus());
        carAdDAO.updateStatus(carAd.getId(), true);
        assertTrue(carAdDAO.getByID(carAd.getId()).isStatus());
        carAdDAO.delete(carAd);
    }

    */
/**
     * Тест получения всех объявлений одного пользователя.
     *//*

    @Test
    public void getAllByUserId() {
        CarAd carAd = new CarAd();
        setCarAd(carAd);
        carAdDAO.create(carAd);
        assertThat(Arrays.asList(camryAd, carAd), is(carAdDAO.getAllByUserId(user.getId())));
        carAdDAO.delete(carAd);
    }

    */
/**
     * Тест getAllFromFilter(). Получение всех Toyota.
     *//*

    @Test
    public void getAllToyotaFromFilter() {
        CarAd carAd = new CarAd();
        setCarAd(carAd);
        carAdDAO.create(carAd);
        assertThat(Arrays.asList(camryAd),
                is(carAdDAO.getAllFromFilter(toyota.getId(), 0, false, false)));
        carAdDAO.delete(carAd);
    }

    */
/**
     * Тест getAllFromFilter(). Получение всех Ford Focus.
     *//*

    @Test
    public void getAllFocusFromFilter() {
        CarAd carAd = new CarAd();
        setCarAd(carAd);
        carAdDAO.create(carAd);
        assertThat(Arrays.asList(carAd),
                is(carAdDAO.getAllFromFilter(0, focus.getId(), false, false)));
        carAdDAO.delete(carAd);
    }

    */
/**
     * Тест getAllFromFilter(). Получение объявлений, в которых есть фото.
     *//*

    @Test
    public void getAllWithFotoFromFilter() {
        CarAd carAd = new CarAd();
        setCarAd(carAd);
        carAdDAO.create(carAd);
        assertThat(Arrays.asList(carAd),
                is(carAdDAO.getAllFromFilter(0, 0, true, false)));
        carAdDAO.delete(carAd);
    }
}*/
