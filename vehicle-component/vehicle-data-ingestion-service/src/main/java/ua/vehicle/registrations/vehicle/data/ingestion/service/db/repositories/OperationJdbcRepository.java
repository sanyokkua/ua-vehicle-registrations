package ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.entities.Operation;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories.customs.CustomInsertRepository;

@Repository
public interface OperationJdbcRepository extends CrudRepository<Operation, Long>, CustomInsertRepository<Operation> {

    @Cacheable(cacheNames = "operation", unless = "#result == false ", key = "#aLong.hashCode()")
    @Override
    boolean existsById(Long aLong);
}
