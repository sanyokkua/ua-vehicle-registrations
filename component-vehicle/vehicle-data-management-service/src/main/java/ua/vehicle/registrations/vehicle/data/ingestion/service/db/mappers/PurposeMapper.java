package ua.vehicle.registrations.vehicle.data.ingestion.service.db.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.vehicle.registrations.dto.flat.PurposeFlatDto;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.mappers.abstraction.BaseCsvVehicleRegistrationRecordMapper;
import ua.vehicle.registrations.vehicle.data.ingestion.service.dto.CsvVehicleRegistrationRecordDto;

@Mapper(componentModel = "spring")
public interface PurposeMapper extends BaseCsvVehicleRegistrationRecordMapper<PurposeFlatDto> {

    @Mapping(source = "purposeName", target = "purposeName", defaultValue = "N/A")
    @Override
    PurposeFlatDto map(CsvVehicleRegistrationRecordDto source);
}
