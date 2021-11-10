package ua.vehicle.registrations.data.db.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.vehicle.registrations.data.db.mappers.abstraction.BaseCsvVehicleRegistrationRecordMapper;
import ua.vehicle.registrations.data.dto.CsvVehicleRegistrationRecordDto;
import ua.vehicle.registrations.dto.flat.PurposeFlatDto;

@Mapper(componentModel = "spring")
public interface PurposeMapper extends BaseCsvVehicleRegistrationRecordMapper<PurposeFlatDto> {

    @Mapping(source = "purposeName", target = "purposeName", defaultValue = "N/A")
    @Override
    PurposeFlatDto map(CsvVehicleRegistrationRecordDto source);
}
