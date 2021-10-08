package ua.vehicle.registrations.vehicle.data.ingestion.service.db.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.entities.Kind;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.mappers.abstraction.BaseCsvVehicleRegistrationRecordMapper;
import ua.vehicle.registrations.vehicle.data.ingestion.service.dto.CsvVehicleRegistrationRecordDto;

@Mapper(componentModel = "spring")
public interface KindMapper extends BaseCsvVehicleRegistrationRecordMapper<Kind> {

    @Mapping(source = "kindName", target = "kindName", defaultValue = "N/A")
    @Override
    Kind map(CsvVehicleRegistrationRecordDto source);
}
