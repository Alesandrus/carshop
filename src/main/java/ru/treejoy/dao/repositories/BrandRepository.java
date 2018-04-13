package ru.treejoy.dao.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.treejoy.model.brands.Brand;

public interface BrandRepository extends CrudRepository<Brand, Long> {
}
