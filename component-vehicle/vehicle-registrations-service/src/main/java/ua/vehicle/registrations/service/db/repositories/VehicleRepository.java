package ua.vehicle.registrations.service.db.repositories;

import org.springframework.stereotype.Repository;
import ua.vehicle.registrations.service.api.BaseRepository;
import ua.vehicle.registrations.service.db.entities.VehicleEntity;

@Repository
public interface VehicleRepository extends BaseRepository<VehicleEntity, Long> {}
