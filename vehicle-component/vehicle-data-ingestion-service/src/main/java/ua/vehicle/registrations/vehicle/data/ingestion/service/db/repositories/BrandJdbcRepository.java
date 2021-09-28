package ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.entities.Brand;

@Repository
public interface BrandJdbcRepository extends CrudRepository<Brand, String> {

    @Cacheable(cacheNames = "brand", unless = "#result == false ", key = "#s.hashCode()")
    @Override
    boolean existsById(String s);
}
