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
 * Класс DAO для CRUD операций с автомобильным брендом в базе данных.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 30.01.2018
 */
@Service("brandService")
@Repository
@Transactional
public class HibernateBrandService implements BrandService {
    /**
     * Логгер.
     */
    private static final Logger LOGGER = LogManager.getLogger(Logger.class.getName());

    private static final HibernateBrandService HIBERNATE_BRAND_SERVICE = new HibernateBrandService();

    @Autowired
    private BrandRepository brandRepository;

    private HibernateBrandService() {
    }

    public static HibernateBrandService getInstance() {
        return HIBERNATE_BRAND_SERVICE;
    }

    /**
     * Создание автомобильного бренда в базе данных.
     *
     * @param entity автомобильный бренд.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void create(Brand entity) {
        brandRepository.save(entity);
    }

    /**
     * Получение всех автомобильных брендов из базы данных.
     *
     * @return список автомобильных брендов.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Brand> getAll() {
        return Lists.newArrayList(brandRepository.findAll());
    }

    /**
     * Получение автомобильного бренда из базы данных по ID.
     *
     * @param id автомобильного бренда.
     * @return автомобильный бренд.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Brand getByID(long id) {
        return brandRepository.findById(id).orElse(null);
    }

    /**
     * Обновить автомобильный бренд в базе данных.
     *
     * @param entity автомобильный бренд.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(Brand entity) {
        brandRepository.save(entity);
    }

    /**
     * Удалить автомобильный бренд из базы данных. Скорее всего каскадно не удалит.
     *
     * @param entity автомобильный бренд.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Brand entity) {
        brandRepository.delete(entity);
    }
}
