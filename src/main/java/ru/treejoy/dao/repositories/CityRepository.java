package ru.treejoy.dao.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.treejoy.model.geo.City;

import java.util.List;

/**
 * CityRepository.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 10.04.2018
 */
public interface CityRepository extends CrudRepository<City, Long> {
    List<City> findAllByCountryId(long id);
}
