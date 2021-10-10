package ua.vehicle.registrations.vehicle.data.ingestion.service.processing.recordhandlers.implementations;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.entities.Body;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.mappers.abstraction.BaseCsvVehicleRegistrationRecordMapper;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories.abstraction.RawSqlRepository;
import ua.vehicle.registrations.vehicle.data.ingestion.service.processing.recordhandlers.abstraction.RegistrationBaseHandler;

@Slf4j
@Component
public class BodyHandler extends RegistrationBaseHandler<Body> {

    @Autowired
    public BodyHandler(RawSqlRepository<Body> repository, BaseCsvVehicleRegistrationRecordMapper<Body> mapper) {
        super(repository, mapper);
    }
}
