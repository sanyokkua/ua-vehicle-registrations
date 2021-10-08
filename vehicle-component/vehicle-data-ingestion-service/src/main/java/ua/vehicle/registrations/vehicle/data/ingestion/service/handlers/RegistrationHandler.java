package ua.vehicle.registrations.vehicle.data.ingestion.service.handlers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.mappers.RegistrationMapper;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.mappers.VehicleMapper;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories.RegistrationJdbcRepository;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories.VehicleJdbcRepository;
import ua.vehicle.registrations.vehicle.data.ingestion.service.dto.CsvVehicleRegistrationRecordDto;
import ua.vehicle.registrations.vehicle.data.ingestion.service.handlers.abstraction.RegistrationBaseHandler;

import java.util.Objects;

@Component
@Slf4j
@RequiredArgsConstructor
public class RegistrationHandler extends RegistrationBaseHandler {
    private final RegistrationJdbcRepository registrationJdbcRepository;
    private final VehicleJdbcRepository vehicleJdbcRepository;
    private final VehicleMapper vehicleMapper;
    private final RegistrationMapper registrationMapper;

    @Override
    protected void process(CsvVehicleRegistrationRecordDto obj) {
        var vehicle = vehicleMapper.map(obj);
        var vehicleFromDb = vehicleJdbcRepository.findVehicle(vehicle);

        if (Objects.isNull(vehicleFromDb) || Objects.isNull(vehicleFromDb.getVehicleId())) {
            log.error("There is no vehicle in DB for this record {}", obj);
            throw new IllegalArgumentException("This record can't be processed. Vehicle does not exist in DB");
        }

        var registration = registrationMapper.map(obj);
        registration.setVehicleId(vehicleFromDb.getVehicleId());

        if (Objects.isNull(registrationJdbcRepository.findRegistration(registration))) {
            registrationJdbcRepository.customInsert(registration);
        }
    }
}
