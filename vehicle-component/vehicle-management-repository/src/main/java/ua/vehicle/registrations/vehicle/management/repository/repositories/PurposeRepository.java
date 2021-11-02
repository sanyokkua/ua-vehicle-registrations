package ua.vehicle.registrations.vehicle.management.repository.repositories;

import org.springframework.stereotype.Repository;
import ua.vehicle.registrations.vehicle.management.repository.dbapi.BaseRepository;
import ua.vehicle.registrations.vehicle.service.dto.jpa.PurposeEntity;

@Repository
public interface PurposeRepository extends BaseRepository<PurposeEntity, String> {

}