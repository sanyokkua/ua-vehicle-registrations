package ua.vehicle.registrations.data.processing.recordhandlers.implementations;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.vehicle.registrations.data.db.mappers.abstraction.BaseCsvVehicleRegistrationRecordMapper;
import ua.vehicle.registrations.data.db.repositories.abstraction.RawSqlRepository;
import ua.vehicle.registrations.data.processing.recordhandlers.abstraction.RegistrationBaseHandler;
import ua.vehicle.registrations.dto.flat.ModelFlatDto;

@Component
@Slf4j
public class ModelHandler extends RegistrationBaseHandler<ModelFlatDto> {

    @Autowired
    public ModelHandler(RawSqlRepository<ModelFlatDto> repository,
            BaseCsvVehicleRegistrationRecordMapper<ModelFlatDto> mapper
    ) {
        super(repository, mapper);
    }
}
