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
 * Implementation of CityService.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 10.04.2018
 */
@Service("cityService")
@Repository
@Transactional
public class HibernateCityService implements CityService {
    /**
     * Logger.
     */
    private static final Logger LOGGER = LogManager.getLogger(Logger.class.getName());

    /**
     * Singleton object.
     */
    private static final HibernateCityService HIBERNATE_CITY_SERVICE = new HibernateCityService();

    /**
     * City repository.
     */
    @Autowired
    private CityRepository cityRepository;

    /**
     * Private constructor.
     */
    private HibernateCityService() {
    }

    /**
     * Getting instance of HibernateCityService.
     *
     * @return HibernateCityService.
     */
    public static HibernateCityService getInstance() {
        return HIBERNATE_CITY_SERVICE;
    }

    /**
     * Saves city.
     *
     * @param entity city.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void create(City entity) {
        cityRepository.save(entity);
    }

    /**
     * Get all cities.
     *
     * @return list of cities.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<City> getAll() {
        return Lists.newArrayList(cityRepository.findAll());
    }

    /**
     * Get city by ID.
     *
     * @param id city's.
     * @return city.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public City getByID(long id) {
        return cityRepository.findById(id).orElse(null);
    }

    /**
     * Update city.
     *
     * @param entity city.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(City entity) {
        cityRepository.save(entity);
    }

    /**
     * Delete city.
     *
     * @param entity city.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(City entity) {
        cityRepository.delete(entity);
    }

    /**
     * Get all cities for country.
     *
     * @param id country's.
     * @return list of cities.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<City> findAllByCountryId(long id) {
        return cityRepository.findAllByCountryId(id);
    }
}
