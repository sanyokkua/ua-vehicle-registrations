package ua.vehicle.registrations.vehicle.data.ingestion.service.handlers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.mappers.BrandMapper;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories.BrandJdbcRepository;
import ua.vehicle.registrations.vehicle.data.ingestion.service.dto.CsvVehicleRegistrationRecordDto;
import ua.vehicle.registrations.vehicle.data.ingestion.service.handlers.abstraction.RegistrationBaseHandler;

@Component
@Slf4j
@RequiredArgsConstructor
public class BrandHandler extends RegistrationBaseHandler {
    private final BrandJdbcRepository repository;
    private final BrandMapper brandMapper;

    @Override
    protected void process(CsvVehicleRegistrationRecordDto obj) {
        var brand = brandMapper.map(obj);
        if (!repository.existsById(brand.getBrandName())) {
            repository.customInsert(brand);
        }
    }
}
