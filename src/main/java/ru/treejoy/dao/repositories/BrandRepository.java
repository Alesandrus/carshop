package ru.treejoy.dao.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.treejoy.model.brands.Brand;

/**
 * BrandRepository.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 10.04.2018
 */
public interface BrandRepository extends CrudRepository<Brand, Long> {
}
