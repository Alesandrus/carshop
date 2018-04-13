package ru.treejoy.dao.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.treejoy.model.geo.City;

import java.util.List;

public interface CityRepository extends CrudRepository<City, Long> {
    List<City> findAllByCountryId(long id);
}
