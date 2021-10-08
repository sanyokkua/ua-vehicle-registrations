package ua.vehicle.registrations.vehicle.data.ingestion.service.handlers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.mappers.VehicleMapper;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories.VehicleJdbcRepository;
import ua.vehicle.registrations.vehicle.data.ingestion.service.dto.CsvVehicleRegistrationRecordDto;
import ua.vehicle.registrations.vehicle.data.ingestion.service.handlers.abstraction.RegistrationBaseHandler;

import java.util.Objects;

@Component
@Slf4j
@RequiredArgsConstructor
public class VehicleHandler extends RegistrationBaseHandler {
    private final VehicleJdbcRepository repository;
    private final VehicleMapper vehicleMapper;

    @Override
    protected void process(CsvVehicleRegistrationRecordDto obj) {
        var vehicle = vehicleMapper.map(obj);
        if (Objects.isNull(repository.findVehicle(vehicle))) {
            repository.customInsert(vehicle);
        }
    }
}
