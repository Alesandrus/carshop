package ru.treejoy.utils;

import ru.treejoy.dao.CityDAO;
import ru.treejoy.dao.CountryDAO;
import ru.treejoy.dao.daofactory.DAOFactory;
import ru.treejoy.model.geo.City;
import ru.treejoy.model.geo.Country;

/**
 * Класс для наполнения городами и странами базы данных с помощью хайбернейт.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 11.02.2018
 */
public class GeoPopulate {
    /**
     * Заполнение базы даннх.
     */
    private static void populate() {
        DAOFactory daoFactory = DAOFactory.getDAOFactory(1);
        CityDAO cityDAO = daoFactory.getCityDAO();
        CountryDAO countryDAO = daoFactory.getCountryDAO();
        Country usa = new Country();
        usa.setName("USA");
        countryDAO.create(usa);
        City newYork = new City();
        newYork.setName("New York");
        newYork.setCountry(usa);
        cityDAO.create(newYork);
        City boston = new City();
        boston.setName("Boston");
        boston.setCountry(usa);
        cityDAO.create(boston);
        City losAngeles = new City();
        losAngeles.setName("Los Angeles");
        losAngeles.setCountry(usa);
        cityDAO.create(losAngeles);
        City lasVegas = new City();
        lasVegas.setName("Las Vegas");
        lasVegas.setCountry(usa);
        cityDAO.create(lasVegas);

        Country russia = new Country();
        russia.setName("Russia");
        countryDAO.create(russia);
        City moscow = new City();
        moscow.setName("Moscow");
        moscow.setCountry(russia);
        cityDAO.create(moscow);
        City stPetersburg = new City();
        stPetersburg.setName("Saint Petersburg");
        stPetersburg.setCountry(russia);
        cityDAO.create(stPetersburg);
        City belgorod = new City();
        belgorod.setName("Belgorod");
        belgorod.setCountry(russia);
        cityDAO.create(belgorod);
        City voronezh = new City();
        voronezh.setName("Voronezh");
        voronezh.setCountry(russia);
        cityDAO.create(voronezh);
        City kursk = new City();
        kursk.setName("Kursk");
        kursk.setCountry(russia);
        cityDAO.create(kursk);
        daoFactory.closeFactory();
    }

    /**
     * Мэйн.
     *
     * @param args .
     */
    public static void main(String[] args) {
        populate();
    }
}
