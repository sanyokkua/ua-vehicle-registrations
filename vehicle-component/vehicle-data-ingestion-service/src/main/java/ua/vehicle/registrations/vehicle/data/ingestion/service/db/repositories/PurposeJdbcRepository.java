package ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.entities.Purpose;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories.customs.CustomInsertRepository;

@Repository
public interface PurposeJdbcRepository extends CrudRepository<Purpose, String>, CustomInsertRepository<Purpose> {

    @Cacheable(cacheNames = "purpose", unless = "#result == false ", key = "#s.hashCode()")
    @Override
    boolean existsById(String s);
}
