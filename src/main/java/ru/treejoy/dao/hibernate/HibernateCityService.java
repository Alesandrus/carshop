package ru.treejoy.dao.hibernate;

import com.google.common.collect.Lists;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.treejoy.dao.services.CityService;
import ru.treejoy.dao.repositories.CityRepository;
import ru.treejoy.model.geo.City;

import java.util.List;

/**
 * Класс DAO для CRUD операций с городом в базе данных.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 30.01.2018
 */
@Service("cityService")
@Repository
@Transactional
public class HibernateCityService implements CityService {
    /**
     * Логгер.
     */
    private static final Logger LOGGER = LogManager.getLogger(Logger.class.getName());

    private static final HibernateCityService HIBERNATE_CITY_SERVICE = new HibernateCityService();

    @Autowired
    private CityRepository cityRepository;

    private HibernateCityService() {
    }

    public static HibernateCityService getInstance() {
        return HIBERNATE_CITY_SERVICE;
    }

    /**
     * Создание города в базе данных.
     *
     * @param entity город.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void create(City entity) {
        cityRepository.save(entity);
    }

    /**
     * Получение всех городов из базы данных.
     *
     * @return список городов.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<City> getAll() {
        return Lists.newArrayList(cityRepository.findAll());
    }

    /**
     * Получение города из базы данных по ID.
     *
     * @param id города.
     * @return город.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public City getByID(long id) {
        return cityRepository.findById(id).orElse(null);
    }

    /**
     * Обновить город в базе данных.
     *
     * @param entity город.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(City entity) {
        cityRepository.save(entity);
    }

    /**
     * Удалить город из базы данных. Скорее всего каскадно не удалит.
     *
     * @param entity город.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(City entity) {
        cityRepository.delete(entity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<City> findAllByCountryId(long id) {
        return cityRepository.findAllByCountryId(id);
    }
}
