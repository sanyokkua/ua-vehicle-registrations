package ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.entities.Body;

@Repository
public interface BodyJdbcRepository extends CrudRepository<Body, String> {

    @Cacheable(cacheNames = "body", unless = "#result == false ", key = "#s.hashCode()")
    @Override
    boolean existsById(String s);
}
