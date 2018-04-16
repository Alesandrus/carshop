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
 * Implementation of CarAdService.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 10.04.2018
 */
@Service("carAdService")
@Repository
@Transactional
public class HibernateCarAdService implements CarAdService {
    /**
     * Logger.
     */
    private static final Logger LOGGER = LogManager.getLogger(Logger.class.getName());

    /**
     * Singleton object.
     */
    private static final HibernateCarAdService HIBERNATE_CAR_AD_SERVICE = new HibernateCarAdService();

    /**
     * Car ad repository.
     */
    @Autowired
    private CarAdRepository carAdRepository;

    /**
     * JPA Entity manager.
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * Private constructor.
     */
    private HibernateCarAdService() {
    }

    /**
     * Getting instance of HibernateCarAdService.
     *
     * @return HibernateCarAdService.
     */
    public static HibernateCarAdService getInstance() {
        return HIBERNATE_CAR_AD_SERVICE;
    }

    /**
     * Saves car ad.
     *
     * @param entity car ad.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void create(CarAd entity) {
        carAdRepository.save(entity);
    }

    /**
     * Get all car ads.
     *
     * @return list of car ads.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<CarAd> getAll() {
        return Lists.newArrayList(carAdRepository.findAll());
    }

    /**
     * Get car ad by ID.
     *
     * @param id car ad.
     * @return car ad.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public CarAd getByID(long id) {
        return carAdRepository.findById(id).orElse(null);
    }

    /**
     * Update car ad.
     *
     * @param entity car ad.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(CarAd entity) {
        carAdRepository.save(entity);
    }

    /**
     * Delete car ad.
     *
     * @param carAd for removing.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(CarAd carAd) {
        carAdRepository.delete(carAd);
    }

    /**
     * Update status sale.
     *
     * @param id car ad's.
     * @param status true if car is sold.
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
     * Get all car ads by user.
     *
     * @param id user's.
     * @return list of car ads.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<CarAd> getAllByUserId(long id) {
        return carAdRepository.findAllByCreatorIdOrderByCreated(id);
    }

    /**
     * Get all car ads by brand, model, presence photo or posted today.
     *
     * @param brandID      ID brand's.
     * @param modelID      ID model's.
     * @param onlyWithFoto true if presence photo.
     * @param today        true if posted today.
     * @return list of car ads.
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
