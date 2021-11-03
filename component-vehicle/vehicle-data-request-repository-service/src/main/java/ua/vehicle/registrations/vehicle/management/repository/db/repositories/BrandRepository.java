package ua.vehicle.registrations.vehicle.management.repository.db.repositories;

import org.springframework.stereotype.Repository;
import ua.vehicle.registrations.vehicle.management.repository.api.BaseRepository;
import ua.vehicle.registrations.vehicle.management.repository.db.jpa.BrandEntity;

@Repository
public interface BrandRepository extends BaseRepository<BrandEntity, String> {

}
