package ua.vehicle.registrations.vehicle.data.ingestion.service.db.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.entities.Body;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.mappers.abstraction.BaseCsvVehicleRegistrationRecordMapper;
import ua.vehicle.registrations.vehicle.data.ingestion.service.dto.CsvVehicleRegistrationRecordDto;

@Mapper(componentModel = "spring")
public interface BodyMapper extends BaseCsvVehicleRegistrationRecordMapper<Body> {

    @Mapping(source = "bodyType", target = "bodyType", defaultValue = "N/A")
    @Override
    Body map(CsvVehicleRegistrationRecordDto source);
}
