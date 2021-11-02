package ua.vehicle.registrations.vehicle.data.ingestion.service.db.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.mappers.abstraction.BaseCsvVehicleRegistrationRecordMapper;
import ua.vehicle.registrations.vehicle.data.ingestion.service.dto.CsvVehicleRegistrationRecordDto;
import ua.vehicle.registrations.vehicle.service.dto.flat.BodyFlatDto;

@Mapper(componentModel = "spring")
public interface BodyMapper extends BaseCsvVehicleRegistrationRecordMapper<BodyFlatDto> {

    @Mapping(source = "bodyType", target = "bodyType", defaultValue = "N/A")
    @Override
    BodyFlatDto map(CsvVehicleRegistrationRecordDto source);
}
