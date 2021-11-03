package ua.vehicle.registrations.vehicle.management.repository.db.repositories;

import org.springframework.stereotype.Repository;
import ua.vehicle.registrations.vehicle.management.repository.api.BaseRepository;
import ua.vehicle.registrations.vehicle.management.repository.db.jpa.PurposeEntity;

@Repository
public interface PurposeRepository extends BaseRepository<PurposeEntity, String> {

}
