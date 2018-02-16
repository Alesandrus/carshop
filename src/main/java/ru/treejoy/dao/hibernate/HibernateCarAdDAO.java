package ru.treejoy.dao.hibernate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Filter;
import org.hibernate.Session;
import ru.treejoy.dao.CarAdDAO;
import ru.treejoy.dao.daofactory.HibernateDAOFactory;
import ru.treejoy.model.ad.CarAd;

import javax.persistence.Query;
import java.util.List;

/**
 * Класс DAO для CRUD операций с автомобильным объявлением в базе данных.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 30.01.2018
 */
public class HibernateCarAdDAO extends CarAdDAO {
    /**
     * Логгер.
     */
    private static final Logger LOGGER = LogManager.getLogger(Logger.class.getName());

    /**
     * Фабрика, для получения соединения с базой данных.
     */
    private HibernateDAOFactory factory = HibernateDAOFactory.getInstance();

    /**
     * Создание автомобильного объявления в базе данных.
     *
     * @param entity автомобильное объявление.
     */
    @Override
    public void create(CarAd entity) {
        Session session = factory.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Получение всех автомобильных объявлений из базы данных.
     *
     * @return список автомобильных объявлений.
     */
    @Override
    public List<CarAd> getAll() {
        Session session = factory.getSessionFactory().openSession();
        session.beginTransaction();
        List<CarAd> items = session.createQuery("from CarAd ORDER BY created").list();
        session.getTransaction().commit();
        session.close();
        return items;
    }

    /**
     * Получение автомобильного объявления из базы данных по ID.
     *
     * @param id автомобильного объявления.
     * @return автомобильное объявление.
     */
    @Override
    public CarAd getByID(long id) {
        Session session = factory.getSessionFactory().openSession();
        session.beginTransaction();
        CarAd item = session.get(CarAd.class, id);
        session.getTransaction().commit();
        session.close();
        return item;
    }

    /**
     * Обновить автомобильное объявление в базе данных.
     *
     * @param entity автомобильное объявление.
     */
    @Override
    public void update(CarAd entity) {
        Session session = factory.getSessionFactory().openSession();
        session.beginTransaction();
        CarAd brandFromDB = session.get(CarAd.class, entity.getId());
        brandFromDB.setBody(entity.getBody());
        brandFromDB.setKilometrage(entity.getKilometrage());
        brandFromDB.setModel(entity.getModel());
        brandFromDB.setMotor(entity.getMotor());
        brandFromDB.setTransmission(entity.getTransmission());
        brandFromDB.setWheelDrive(entity.getWheelDrive());
        brandFromDB.setYearOfManufacture(entity.getYearOfManufacture());
        brandFromDB.setCity(entity.getCity());
        brandFromDB.setCreator(entity.getCreator());
        brandFromDB.setDescription(entity.getDescription());
        brandFromDB.setImages(entity.getImages());
        brandFromDB.setPrice(entity.getPrice());
        session.update(brandFromDB);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Удалить автомобильное объявление из базы данных. Скорее всего каскадно не удалит.
     *
     * @param carAd автомобильное объявление.
     */
    @Override
    public void delete(CarAd carAd) {
        Session session = factory.getSessionFactory().openSession();
        session.beginTransaction();
        session.remove(carAd);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Обновить статус автомобильного объявления.
     *
     * @param id автомобильного объявления.
     */
    @Override
    public void updateStatus(long id, boolean status) {
        Session session = factory.getSessionFactory().openSession();
        session.beginTransaction();
        CarAd carAd = session.get(CarAd.class, id);
        carAd.setStatus(status);
        session.update(carAd);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Получить все объявления одного пользователя.
     *
     * @param id пользователя.
     * @return список объявления пользователя.
     */
    @Override
    public List<CarAd> getAllByUserId(long id) {
        Session session = factory.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from CarAd WHERE user_id =:id ORDER BY created");
        query.setParameter("id", id);
        List<CarAd> ads = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return ads;
    }

    /**
     * Получить список объявлений, удовлетворяющих условиям.
     *
     * @param brandID      ID бренда.
     * @param modelID      ID модели.
     * @param onlyWithFoto только с фото.
     * @param today        за сегодня.
     * @return список объявлений.
     */
    @Override
    public List<CarAd> getAllFromFilter(long brandID, long modelID, boolean onlyWithFoto, boolean today) {
        Session session = factory.getSessionFactory().openSession();
        session.beginTransaction();
        if (brandID != 0 && modelID == 0) {
            Filter filter = session.enableFilter("limitByBrand");
            filter.setParameter("brandID", brandID);
        } else if (modelID != 0) {
            Filter filter = session.enableFilter("limitByModel");
            filter.setParameter("modelID", modelID);
        }
        if (onlyWithFoto) {
            session.enableFilter("limitByImage");
        }
        if (today) {
            session.enableFilter("limitToDay");
        }
        List<CarAd> items = session.createQuery("from CarAd ORDER BY created").list();
        session.getTransaction().commit();
        session.close();
        return items;
    }
}
