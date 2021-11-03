package ua.vehicle.registrations.vehicle.data.ingestion.service.processing.recordhandlers.implementations;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.vehicle.registrations.dto.flat.ColorFlatDto;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.mappers.abstraction.BaseCsvVehicleRegistrationRecordMapper;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories.abstraction.RawSqlRepository;
import ua.vehicle.registrations.vehicle.data.ingestion.service.processing.recordhandlers.abstraction.RegistrationBaseHandler;

@Slf4j
@Component
public class ColorHandler extends RegistrationBaseHandler<ColorFlatDto> {

    @Autowired
    public ColorHandler(RawSqlRepository<ColorFlatDto> repository, BaseCsvVehicleRegistrationRecordMapper<ColorFlatDto> mapper) {
        super(repository, mapper);
    }
}
