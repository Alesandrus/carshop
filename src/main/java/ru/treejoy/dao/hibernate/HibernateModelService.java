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
 * Implementation of ModelService.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 10.04.2018
 */
@Service("modelService")
@Repository
@Transactional
public class HibernateModelService implements ModelService {
    /**
     * Logger.
     */
    private static final Logger LOGGER = LogManager.getLogger(Logger.class.getName());

    /**
     * Singleton object.
     */
    private static final HibernateModelService HIBERNATE_MODEL_SERVICE = new HibernateModelService();

    /**
     * Model repository.
     */
    @Autowired
    private ModelRepository modelRepository;

    /**
     * Private constructor.
     */
    private HibernateModelService() {
    }

    /**
     * Getting instance of HibernateModelService.
     *
     * @return HibernateModelService.
     */
    public static HibernateModelService getInstance() {
        return HIBERNATE_MODEL_SERVICE;
    }

    /**
     * Saves model.
     *
     * @param entity model.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void create(Model entity) {
        modelRepository.save(entity);
    }

    /**
     * Get all models.
     *
     * @return list of models.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Model> getAll() {
        return Lists.newArrayList(modelRepository.findAll());
    }

    /**
     * Get model by ID.
     *
     * @param id model's.
     * @return model's.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Model getByID(long id) {
        return modelRepository.findById(id).orElse(null);
    }

    /**
     * Update model.
     *
     * @param entity model.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(Model entity) {
        modelRepository.save(entity);
    }

    /**
     * Delete model.
     *
     * @param entity model.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Model entity) {
        modelRepository.delete(entity);
    }

    /**
     * Get all models by brand.
     *
     * @param id brand's.
     * @return list of models.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Model> findAllByBrandID(long id) {
        return modelRepository.findAllByBrand_Id(id);
    }
}
