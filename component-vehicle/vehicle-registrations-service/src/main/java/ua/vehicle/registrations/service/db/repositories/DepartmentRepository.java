package ua.vehicle.registrations.service.db.repositories;

import org.springframework.stereotype.Repository;
import ua.vehicle.registrations.service.api.BaseRepository;
import ua.vehicle.registrations.service.db.entities.DepartmentEntity;

@Repository
public interface DepartmentRepository extends BaseRepository<DepartmentEntity, Long> {}
