package ua.vehicle.registrations.vehicle.data.ingestion.service.processing.recordhandlers.implementations;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.entities.Registration;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.mappers.VehicleMapper;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.mappers.abstraction.BaseCsvVehicleRegistrationRecordMapper;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories.abstraction.RawSqlRepository;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories.postgresql.VehiclePostgreSqlRepository;
import ua.vehicle.registrations.vehicle.data.ingestion.service.dto.CsvVehicleRegistrationRecordDto;
import ua.vehicle.registrations.vehicle.data.ingestion.service.processing.recordhandlers.abstraction.RegistrationBaseHandler;

import java.util.Objects;

@Component
@Slf4j
public class RegistrationHandler extends RegistrationBaseHandler<Registration> {

    private final VehiclePostgreSqlRepository vehicleJdbcRepository;
    private final VehicleMapper vehicleMapper;

    @Autowired
    public RegistrationHandler(RawSqlRepository<Registration> repository, BaseCsvVehicleRegistrationRecordMapper<Registration> mapper, VehiclePostgreSqlRepository vehicleJdbcRepository, VehicleMapper vehicleMapper) {
        super(repository, mapper);
        this.vehicleJdbcRepository = vehicleJdbcRepository;
        this.vehicleMapper = vehicleMapper;
    }

    @Override
    protected void process(CsvVehicleRegistrationRecordDto obj) {
        var vehicle = vehicleMapper.map(obj);
        var vehicleFromDb = vehicleJdbcRepository.customFind(vehicle);
        if (Objects.isNull(vehicleFromDb) || Objects.isNull(vehicleFromDb.getVehicleId())) {
            log.error("There is no vehicle in DB for this record {}", obj);
            throw new IllegalArgumentException("This record can't be processed. Vehicle does not exist in DB");
        }
        var registration = mapper.map(obj);
        registration.setVehicleId(vehicleFromDb.getVehicleId());
        if (Objects.isNull(repository.customFind(registration))) {
            repository.customInsert(registration);
        }
    }
}
