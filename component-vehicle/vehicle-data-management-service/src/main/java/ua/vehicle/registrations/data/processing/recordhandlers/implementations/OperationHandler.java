package ua.vehicle.registrations.data.processing.recordhandlers.implementations;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.vehicle.registrations.data.db.mappers.abstraction.BaseCsvVehicleRegistrationRecordMapper;
import ua.vehicle.registrations.data.db.repositories.abstraction.RawSqlRepository;
import ua.vehicle.registrations.data.processing.recordhandlers.abstraction.RegistrationBaseHandler;
import ua.vehicle.registrations.dto.flat.OperationFlatDto;

@Component
@Slf4j
public class OperationHandler extends RegistrationBaseHandler<OperationFlatDto> {

    @Autowired
    public OperationHandler(RawSqlRepository<OperationFlatDto> repository,
            BaseCsvVehicleRegistrationRecordMapper<OperationFlatDto> mapper
    ) {
        super(repository, mapper);
    }
}
