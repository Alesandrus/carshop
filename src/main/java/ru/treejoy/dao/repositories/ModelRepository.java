package ru.treejoy.dao.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.treejoy.model.brands.Model;

import java.util.List;

public interface ModelRepository extends CrudRepository<Model, Long> {
    List<Model> findAllByBrand_Id(Long id);
}
