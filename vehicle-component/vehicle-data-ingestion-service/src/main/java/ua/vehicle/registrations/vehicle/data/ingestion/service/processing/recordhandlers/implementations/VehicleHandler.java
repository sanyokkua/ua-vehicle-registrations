package ua.vehicle.registrations.vehicle.data.ingestion.service.processing.recordhandlers.implementations;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.entities.Vehicle;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.mappers.abstraction.BaseCsvVehicleRegistrationRecordMapper;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories.abstraction.RawSqlRepository;
import ua.vehicle.registrations.vehicle.data.ingestion.service.dto.CsvVehicleRegistrationRecordDto;
import ua.vehicle.registrations.vehicle.data.ingestion.service.processing.recordhandlers.abstraction.RegistrationBaseHandler;

import java.util.Objects;

@Component
@Slf4j
public class VehicleHandler extends RegistrationBaseHandler<Vehicle> {

    @Autowired
    public VehicleHandler(RawSqlRepository<Vehicle> repository, BaseCsvVehicleRegistrationRecordMapper<Vehicle> mapper) {
        super(repository, mapper);
    }

    @Override
    protected void process(CsvVehicleRegistrationRecordDto obj) {
        var vehicle = mapper.map(obj);
        if (Objects.isNull(repository.customFind(vehicle))) {
            repository.customInsert(vehicle);
        }
    }
}
