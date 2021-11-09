package ua.vehicle.registrations.service.db.repositories;

import org.springframework.stereotype.Repository;
import ua.vehicle.registrations.service.api.BaseRepository;
import ua.vehicle.registrations.service.db.entities.BrandEntity;

@Repository
public interface BrandRepository extends BaseRepository<BrandEntity, String> {}
