package ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.entities.Model;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories.customs.CustomInsertRepository;

@Repository
public interface ModelJdbcRepository extends CrudRepository<Model, String>, CustomInsertRepository<Model> {

    @Cacheable(cacheNames = "model", unless = "#result == false ", key = "#s.hashCode()")
    @Override
    boolean existsById(String s);
}
