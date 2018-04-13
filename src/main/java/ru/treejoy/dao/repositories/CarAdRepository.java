package ru.treejoy.dao.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.treejoy.model.ad.CarAd;

import java.util.List;

public interface CarAdRepository extends CrudRepository<CarAd, Long> {
    List<CarAd> findAllByCreatorIdOrderByCreated(long id);
}
