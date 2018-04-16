package ru.treejoy.dao.hibernate;

import com.google.common.collect.Lists;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.treejoy.dao.services.CountryService;
import ru.treejoy.dao.repositories.CountryRepository;
import ru.treejoy.model.geo.Country;

import java.util.List;

/**
 * Implementation of CountryService.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 10.04.2018
 */
@Service("countryService")
@Repository
@Transactional
public class HibernateCountryService implements CountryService {
    /**
     * Logger.
     */
    private static final Logger LOGGER = LogManager.getLogger(Logger.class.getName());

    /**
     * Singleton object.
     */
    private static final HibernateCountryService HIBERNATE_COUNTRY_SERVICE = new HibernateCountryService();

    /**
     * Country repository.
     */
    @Autowired
    private CountryRepository countryRepository;

    /**
     * Private constructor.
     */
    private HibernateCountryService() {
    }

    /**
     * Getting instance of HibernateCountryService.
     *
     * @return HibernateCountryService.
     */
    public static HibernateCountryService getInstance() {
        return HIBERNATE_COUNTRY_SERVICE;
    }

    /**
     * Saves country.
     *
     * @param entity country.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void create(Country entity) {
        countryRepository.save(entity);
    }

    /**
     * Get all countries.
     *
     * @return list of countries.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Country> getAll() {
        return Lists.newArrayList(countryRepository.findAll());
    }

    /**
     * Get country by ID.
     *
     * @param id country.
     * @return country.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Country getByID(long id) {
        return countryRepository.findById(id).orElse(null);
    }

    /**
     * Update country.
     *
     * @param entity country.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(Country entity) {
        countryRepository.save(entity);
    }

    /**
     * Delete country.
     *
     * @param entity country.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Country entity) {
        countryRepository.delete(entity);
    }
}
