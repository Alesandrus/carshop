package ru.treejoy.dao.hibernate;

import com.google.common.collect.Lists;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.treejoy.dao.services.BrandService;
import ru.treejoy.dao.repositories.BrandRepository;
import ru.treejoy.model.brands.Brand;

import java.util.List;

/**
 * Implementation of BrandService.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 10.04.2018
 */
@Service("brandService")
@Repository
@Transactional
public class HibernateBrandService implements BrandService {
    /**
     * Logger.
     */
    private static final Logger LOGGER = LogManager.getLogger(Logger.class.getName());

    /**
     * Singleton object.
     */
    private static final HibernateBrandService HIBERNATE_BRAND_SERVICE = new HibernateBrandService();

    /**
     * Brand repository.
     */
    @Autowired
    private BrandRepository brandRepository;

    /**
     * Private constructor.
     */
    private HibernateBrandService() {
    }

    /**
     * Getting instance of HibernateBrandService.
     *
     * @return HibernateBrandService.
     */
    public static HibernateBrandService getInstance() {
        return HIBERNATE_BRAND_SERVICE;
    }

    /**
     * Saves brand.
     *
     * @param entity brand.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void create(Brand entity) {
        brandRepository.save(entity);
    }

    /**
     * Get all brands.
     *
     * @return list of brands.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Brand> getAll() {
        return Lists.newArrayList(brandRepository.findAll());
    }

    /**
     * Get brand by ID.
     *
     * @param id brand.
     * @return brand.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Brand getByID(long id) {
        return brandRepository.findById(id).orElse(null);
    }

    /**
     * Update brand.
     *
     * @param entity brand.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(Brand entity) {
        brandRepository.save(entity);
    }

    /**
     * Delete brand.
     *
     * @param entity brand.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Brand entity) {
        brandRepository.delete(entity);
    }
}
