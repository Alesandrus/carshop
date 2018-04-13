package ru.treejoy.dao.hibernate;

import com.google.common.collect.Lists;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.treejoy.dao.services.ModelService;
import ru.treejoy.dao.repositories.ModelRepository;
import ru.treejoy.model.brands.Model;

import java.util.List;

/**
 * Класс DAO для CRUD операций с моделью автомобиля в базе данных.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 30.01.2018
 */
@Service("modelService")
@Repository
@Transactional
public class HibernateModelService implements ModelService {
    /**
     * Логгер.
     */
    private static final Logger LOGGER = LogManager.getLogger(Logger.class.getName());

    private static final HibernateModelService HIBERNATE_MODEL_SERVICE = new HibernateModelService();

    @Autowired
    private ModelRepository modelRepository;

    private HibernateModelService() {
    }

    public static HibernateModelService getInstance() {
        return HIBERNATE_MODEL_SERVICE;
    }

    /**
     * Создание модели в базе данных.
     *
     * @param entity модель.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void create(Model entity) {
        modelRepository.save(entity);
    }

    /**
     * Получение всех моделей из базы данных.
     *
     * @return список моделей.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Model> getAll() {
        return Lists.newArrayList(modelRepository.findAll());
    }

    /**
     * Получение модели из базы данных по ID.
     *
     * @param id модели.
     * @return модель.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Model getByID(long id) {
        return modelRepository.findById(id).orElse(null);
    }

    /**
     * Обновить модель в базе данных.
     *
     * @param entity модель.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(Model entity) {
        modelRepository.save(entity);
    }

    /**
     * Удалить модель из базы данных. Скорее всего каскадно не удалит.
     *
     * @param entity модель.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Model entity) {
        modelRepository.delete(entity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Model> findAllByBrandID(long id) {
        return modelRepository.findAllByBrand_Id(id);
    }
}
