package ru.treejoy.dao.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.treejoy.model.ad.CarAd;

import java.util.List;

/**
 * CarAdRepository.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 10.04.2018
 */
public interface CarAdRepository extends CrudRepository<CarAd, Long> {
    List<CarAd> findAllByCreatorIdOrderByCreated(long id);
}
