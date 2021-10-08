package ua.vehicle.registrations.vehicle.data.ingestion.service.handlers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.mappers.ColorMapper;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories.ColorJdbcRepository;
import ua.vehicle.registrations.vehicle.data.ingestion.service.dto.CsvVehicleRegistrationRecordDto;
import ua.vehicle.registrations.vehicle.data.ingestion.service.handlers.abstraction.RegistrationBaseHandler;

@Component
@Slf4j
@RequiredArgsConstructor
public class ColorHandler extends RegistrationBaseHandler {
    private final ColorJdbcRepository repository;
    private final ColorMapper colorMapper;

    @Override
    protected void process(CsvVehicleRegistrationRecordDto obj) {
        var color = colorMapper.map(obj);
        if (!repository.existsById(color.getColorName())) {
            repository.customInsert(color);
        }
    }
}
