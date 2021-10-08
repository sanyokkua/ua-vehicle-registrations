package ua.vehicle.registrations.vehicle.data.ingestion.service.handlers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.mappers.ModelMapper;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories.ModelJdbcRepository;
import ua.vehicle.registrations.vehicle.data.ingestion.service.dto.CsvVehicleRegistrationRecordDto;
import ua.vehicle.registrations.vehicle.data.ingestion.service.handlers.abstraction.RegistrationBaseHandler;

@Component
@Slf4j
@RequiredArgsConstructor
public class ModelHandler extends RegistrationBaseHandler {
    private final ModelJdbcRepository repository;
    private final ModelMapper modelMapper;

    @Override
    protected void process(CsvVehicleRegistrationRecordDto obj) {
        var model = modelMapper.map(obj);
        if (!repository.existsById(model.getModelName())) {
            repository.customInsert(model);
        }
    }
}
