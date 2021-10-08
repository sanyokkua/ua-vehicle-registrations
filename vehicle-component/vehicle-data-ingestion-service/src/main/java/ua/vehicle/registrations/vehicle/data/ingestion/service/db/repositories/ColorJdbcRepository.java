package ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.entities.Color;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories.customs.CustomInsertRepository;

@Repository
public interface ColorJdbcRepository extends CrudRepository<Color, String>, CustomInsertRepository<Color> {

    @Cacheable(cacheNames = "color", unless = "#result == false ", key = "#s.hashCode()")
    @Override
    boolean existsById(String s);
}
