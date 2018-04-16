package ru.treejoy.dao.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.treejoy.model.brands.Model;

import java.util.List;

/**
 * ModelRepository.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 10.04.2018
 */
public interface ModelRepository extends CrudRepository<Model, Long> {
    List<Model> findAllByBrand_Id(Long id);
}
