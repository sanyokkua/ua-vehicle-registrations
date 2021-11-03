package ua.vehicle.registrations.vehicle.data.ingestion.service.processing.recordhandlers.implementations;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.vehicle.registrations.dto.flat.PurposeFlatDto;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.mappers.abstraction.BaseCsvVehicleRegistrationRecordMapper;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories.abstraction.RawSqlRepository;
import ua.vehicle.registrations.vehicle.data.ingestion.service.processing.recordhandlers.abstraction.RegistrationBaseHandler;

@Component
@Slf4j
public class PurposeHandler extends RegistrationBaseHandler<PurposeFlatDto> {

    @Autowired
    public PurposeHandler(RawSqlRepository<PurposeFlatDto> repository, BaseCsvVehicleRegistrationRecordMapper<PurposeFlatDto> mapper) {
        super(repository, mapper);
    }
}
