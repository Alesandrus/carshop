package ru.treejoy.dao.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.treejoy.model.geo.Country;

public interface CountryRepository extends CrudRepository<Country, Long> {
}
