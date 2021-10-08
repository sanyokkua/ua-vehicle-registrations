package ua.vehicle.registrations.vehicle.data.ingestion.service.handlers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.mappers.FuelMapper;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories.FuelJdbcRepository;
import ua.vehicle.registrations.vehicle.data.ingestion.service.dto.CsvVehicleRegistrationRecordDto;
import ua.vehicle.registrations.vehicle.data.ingestion.service.handlers.abstraction.RegistrationBaseHandler;

@Component
@Slf4j
@RequiredArgsConstructor
public class FuelHandler extends RegistrationBaseHandler {
    private final FuelJdbcRepository repository;
    private final FuelMapper fuelMapper;

    @Override
    protected void process(CsvVehicleRegistrationRecordDto obj) {
        var fuel = fuelMapper.map(obj);
        if (!repository.existsById(fuel.getFuelType())) {
            repository.customInsert(fuel);
        }
    }
}
