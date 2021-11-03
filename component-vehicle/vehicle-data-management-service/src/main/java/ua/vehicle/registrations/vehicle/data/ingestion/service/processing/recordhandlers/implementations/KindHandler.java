package ua.vehicle.registrations.vehicle.data.ingestion.service.processing.recordhandlers.implementations;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.vehicle.registrations.dto.flat.KindFlatDto;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.mappers.abstraction.BaseCsvVehicleRegistrationRecordMapper;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories.abstraction.RawSqlRepository;
import ua.vehicle.registrations.vehicle.data.ingestion.service.processing.recordhandlers.abstraction.RegistrationBaseHandler;

@Component
@Slf4j
public class KindHandler extends RegistrationBaseHandler<KindFlatDto> {

    @Autowired
    public KindHandler(RawSqlRepository<KindFlatDto> repository, BaseCsvVehicleRegistrationRecordMapper<KindFlatDto> mapper) {
        super(repository, mapper);
    }
}
