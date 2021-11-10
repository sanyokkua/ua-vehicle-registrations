package ua.vehicle.registrations.data.processing.recordhandlers.implementations;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.vehicle.registrations.data.db.mappers.abstraction.BaseCsvVehicleRegistrationRecordMapper;
import ua.vehicle.registrations.data.db.repositories.abstraction.RawSqlRepository;
import ua.vehicle.registrations.data.processing.recordhandlers.abstraction.RegistrationBaseHandler;
import ua.vehicle.registrations.dto.flat.ColorFlatDto;

@Slf4j
@Component
public class ColorHandler extends RegistrationBaseHandler<ColorFlatDto> {

    @Autowired
    public ColorHandler(RawSqlRepository<ColorFlatDto> repository,
            BaseCsvVehicleRegistrationRecordMapper<ColorFlatDto> mapper
    ) {
        super(repository, mapper);
    }
}
