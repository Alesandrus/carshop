package ru.treejoy.utils;

import ru.treejoy.dao.BrandDAO;
import ru.treejoy.dao.ModelDAO;
import ru.treejoy.dao.daofactory.DAOFactory;
import ru.treejoy.model.brands.Brand;
import ru.treejoy.model.brands.Model;

/**
 * Класс для наполнения брендами и моделей базы данных с помощью хайбернейт.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 11.02.2018
 */
public class BrandPopulate {
    /**
     * Заполнение базы даннх.
     */
    private static void populate() {
        DAOFactory daoFactory = DAOFactory.getDAOFactory(1);
        BrandDAO brandDAO = daoFactory.getBrandDAO();
        ModelDAO modelDAO = daoFactory.getModelDAO();
        Brand toyota = new Brand();
        toyota.setName("Toyota");
        brandDAO.create(toyota);
        Brand audi = new Brand();
        audi.setName("Audi");
        brandDAO.create(audi);
        Brand lada = new Brand();
        lada.setName("Lada");
        brandDAO.create(lada);

        Model camry = new Model();
        camry.setName("Camry");
        camry.setBrand(toyota);
        modelDAO.create(camry);
        Model corolla = new Model();
        corolla.setName("Corolla");
        corolla.setBrand(toyota);
        modelDAO.create(corolla);
        Model landCruiser = new Model();
        landCruiser.setName("Land Cruiser");
        landCruiser.setBrand(toyota);
        modelDAO.create(landCruiser);

        Model a4 = new Model();
        a4.setName("A4");
        a4.setBrand(audi);
        modelDAO.create(a4);
        Model a8 = new Model();
        a8.setName("A8");
        a8.setBrand(audi);
        modelDAO.create(a8);
        Model q7 = new Model();
        q7.setName("Q7");
        q7.setBrand(audi);
        modelDAO.create(q7);

        Model priora = new Model();
        priora.setName("Priora");
        priora.setBrand(lada);
        modelDAO.create(priora);
        Model kalina = new Model();
        kalina.setName("Kalina");
        kalina.setBrand(lada);
        modelDAO.create(kalina);
        Model granta = new Model();
        granta.setName("Granta");
        granta.setBrand(lada);
        modelDAO.create(granta);
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
