package ua.vehicle.registrations.data.db.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.vehicle.registrations.data.db.mappers.abstraction.BaseCsvVehicleRegistrationRecordMapper;
import ua.vehicle.registrations.data.dto.CsvVehicleRegistrationRecordDto;
import ua.vehicle.registrations.dto.flat.BodyFlatDto;

@Mapper(componentModel = "spring")
public interface BodyMapper extends BaseCsvVehicleRegistrationRecordMapper<BodyFlatDto> {

    @Mapping(source = "bodyType", target = "bodyType", defaultValue = "N/A")
    @Override
    BodyFlatDto map(CsvVehicleRegistrationRecordDto source);
}
