package ua.vehicle.registrations.vehicle.data.ingestion.service.handlers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.mappers.KindMapper;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories.KindJdbcRepository;
import ua.vehicle.registrations.vehicle.data.ingestion.service.dto.CsvVehicleRegistrationRecordDto;
import ua.vehicle.registrations.vehicle.data.ingestion.service.handlers.abstraction.RegistrationBaseHandler;

@Component
@Slf4j
@RequiredArgsConstructor
public class KindHandler extends RegistrationBaseHandler {
    private final KindJdbcRepository repository;
    private final KindMapper kindMapper;

    @Override
    protected void process(CsvVehicleRegistrationRecordDto obj) {
        var kind = kindMapper.map(obj);
        if (!repository.existsById(kind.getKindName())) {
            repository.customInsert(kind);
        }
    }
}
