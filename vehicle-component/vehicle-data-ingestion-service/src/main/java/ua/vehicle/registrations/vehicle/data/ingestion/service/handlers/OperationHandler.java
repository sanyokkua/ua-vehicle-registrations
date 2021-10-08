package ua.vehicle.registrations.vehicle.data.ingestion.service.handlers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.mappers.OperationMapper;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories.OperationJdbcRepository;
import ua.vehicle.registrations.vehicle.data.ingestion.service.dto.CsvVehicleRegistrationRecordDto;
import ua.vehicle.registrations.vehicle.data.ingestion.service.handlers.abstraction.RegistrationBaseHandler;

@Component
@Slf4j
@RequiredArgsConstructor
public class OperationHandler extends RegistrationBaseHandler {
    private final OperationJdbcRepository repository;
    private final OperationMapper operationMapper;

    @Override
    protected void process(CsvVehicleRegistrationRecordDto obj) {
        var operation = operationMapper.map(obj);
        if (!repository.existsById(operation.getOpCode())) {
            repository.customInsert(operation);
        }
    }
}
