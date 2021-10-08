package ua.vehicle.registrations.vehicle.data.ingestion.service.handlers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.mappers.DepartmentMapper;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories.DepartmentJdbcRepository;
import ua.vehicle.registrations.vehicle.data.ingestion.service.dto.CsvVehicleRegistrationRecordDto;
import ua.vehicle.registrations.vehicle.data.ingestion.service.handlers.abstraction.RegistrationBaseHandler;

@Component
@Slf4j
@RequiredArgsConstructor
public class DepartmentHandler extends RegistrationBaseHandler {
    private final DepartmentJdbcRepository repository;
    private final DepartmentMapper departmentMapper;

    @Override
    protected void process(CsvVehicleRegistrationRecordDto obj) {
        var department = departmentMapper.map(obj);
        if (!repository.existsById(department.getDepCode())) {
            repository.customInsert(department);
        }
    }
}
