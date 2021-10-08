package ua.vehicle.registrations.vehicle.data.ingestion.service.handlers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.mappers.BodyMapper;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories.BodyJdbcRepository;
import ua.vehicle.registrations.vehicle.data.ingestion.service.dto.CsvVehicleRegistrationRecordDto;
import ua.vehicle.registrations.vehicle.data.ingestion.service.handlers.abstraction.RegistrationBaseHandler;

@Component
@Slf4j
@RequiredArgsConstructor
public class BodyHandler extends RegistrationBaseHandler {
    private final BodyJdbcRepository repository;
    private final BodyMapper bodyMapper;

    @Override
    protected void process(CsvVehicleRegistrationRecordDto obj) {
        var body = bodyMapper.map(obj);
        if (!repository.existsById(body.getBodyType())) {
            repository.customInsert(body);
        }
    }
}
