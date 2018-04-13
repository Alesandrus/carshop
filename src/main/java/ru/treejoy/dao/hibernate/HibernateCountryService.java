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
 * Класс DAO для CRUD операций со страной в базе данных.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 30.01.2018
 */
@Service("countryService")
@Repository
@Transactional
public class HibernateCountryService implements CountryService {
    /**
     * Логгер.
     */
    private static final Logger LOGGER = LogManager.getLogger(Logger.class.getName());

    private static final HibernateCountryService HIBERNATE_COUNTRY_SERVICE = new HibernateCountryService();

    @Autowired
    private CountryRepository countryRepository;

    private HibernateCountryService() {
    }

    public static HibernateCountryService getInstance() {
        return HIBERNATE_COUNTRY_SERVICE;
    }

    /**
     * Создание страны в базе данных.
     *
     * @param entity страна.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void create(Country entity) {
        countryRepository.save(entity);
    }

    /**
     * Получение всех стран из базы данных.
     *
     * @return список стран.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Country> getAll() {
        return Lists.newArrayList(countryRepository.findAll());
    }

    /**
     * Получение стран из базы данных по ID.
     *
     * @param id страны.
     * @return страна.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Country getByID(long id) {
        return countryRepository.findById(id).orElse(null);
    }

    /**
     * Обновить страну в базе данных.
     *
     * @param entity страна.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(Country entity) {
        countryRepository.save(entity);
    }

    /**
     * Удалить страну из базы данных. Скорее всего каскадно не удалит.
     *
     * @param entity страна.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Country entity) {
        countryRepository.delete(entity);
    }
}
