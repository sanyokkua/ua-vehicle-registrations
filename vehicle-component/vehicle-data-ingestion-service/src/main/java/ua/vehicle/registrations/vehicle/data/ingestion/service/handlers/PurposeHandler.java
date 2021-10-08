package ua.vehicle.registrations.vehicle.data.ingestion.service.handlers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.mappers.PurposeMapper;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories.PurposeJdbcRepository;
import ua.vehicle.registrations.vehicle.data.ingestion.service.dto.CsvVehicleRegistrationRecordDto;
import ua.vehicle.registrations.vehicle.data.ingestion.service.handlers.abstraction.RegistrationBaseHandler;

@Component
@Slf4j
@RequiredArgsConstructor
public class PurposeHandler extends RegistrationBaseHandler {
    private final PurposeJdbcRepository repository;
    private final PurposeMapper purposeMapper;

    @Override
    protected void process(CsvVehicleRegistrationRecordDto obj) {
        var purpose = purposeMapper.map(obj);
        if (!repository.existsById(purpose.getPurposeName())) {
            repository.customInsert(purpose);
        }
    }
}
