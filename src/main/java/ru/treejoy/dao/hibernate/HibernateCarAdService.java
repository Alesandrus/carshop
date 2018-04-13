package ru.treejoy.dao.hibernate;

import com.google.common.collect.Lists;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.treejoy.dao.services.CarAdService;
import ru.treejoy.dao.repositories.CarAdRepository;
import ru.treejoy.model.ad.CarAd;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Класс DAO для CRUD операций с автомобильным объявлением в базе данных.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 30.01.2018
 */
@Service("carAdService")
@Repository
@Transactional
public class HibernateCarAdService implements CarAdService {
    /**
     * Логгер.
     */
    private static final Logger LOGGER = LogManager.getLogger(Logger.class.getName());

    private static final HibernateCarAdService HIBERNATE_CAR_AD_SERVICE = new HibernateCarAdService();

    @Autowired
    private CarAdRepository carAdRepository;

    @PersistenceContext
    private EntityManager em;

    private HibernateCarAdService() {
    }

    public static HibernateCarAdService getInstance() {
        return HIBERNATE_CAR_AD_SERVICE;
    }

    /**
     * Создание автомобильного объявления в базе данных.
     *
     * @param entity автомобильное объявление.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void create(CarAd entity) {
        carAdRepository.save(entity);
    }

    /**
     * Получение всех автомобильных объявлений из базы данных.
     *
     * @return список автомобильных объявлений.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<CarAd> getAll() {
        return Lists.newArrayList(carAdRepository.findAll());
    }

    /**
     * Получение автомобильного объявления из базы данных по ID.
     *
     * @param id автомобильного объявления.
     * @return автомобильное объявление.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public CarAd getByID(long id) {
        return carAdRepository.findById(id).orElse(null);
    }

    /**
     * Обновить автомобильное объявление в базе данных.
     *
     * @param entity автомобильное объявление.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(CarAd entity) {
        carAdRepository.save(entity);
    }

    /**
     * Удалить автомобильное объявление из базы данных. Скорее всего каскадно не удалит.
     *
     * @param carAd автомобильное объявление.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(CarAd carAd) {
        carAdRepository.delete(carAd);
    }

    /**
     * Обновить статус автомобильного объявления.
     *
     * @param id автомобильного объявления.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateStatus(long id, boolean status) {
        CarAd carAd = carAdRepository.findById(id).orElse(null);
        if (carAd != null) {
            carAd.setStatus(status);
            carAdRepository.save(carAd);
        }
    }

    /**
     * Получить все объявления одного пользователя.
     *
     * @param id пользователя.
     * @return список объявления пользователя.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<CarAd> getAllByUserId(long id) {
        return carAdRepository.findAllByCreatorIdOrderByCreated(id);
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
        Session session = em.getEntityManagerFactory().createEntityManager().unwrap(Session.class);
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
