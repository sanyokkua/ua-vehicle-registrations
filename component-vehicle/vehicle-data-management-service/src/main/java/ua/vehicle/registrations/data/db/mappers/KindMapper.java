package ua.vehicle.registrations.data.db.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.vehicle.registrations.data.db.mappers.abstraction.BaseCsvVehicleRegistrationRecordMapper;
import ua.vehicle.registrations.data.dto.CsvVehicleRegistrationRecordDto;
import ua.vehicle.registrations.dto.flat.KindFlatDto;

@Mapper(componentModel = "spring")
public interface KindMapper extends BaseCsvVehicleRegistrationRecordMapper<KindFlatDto> {

    @Mapping(source = "kindName", target = "kindName", defaultValue = "N/A")
    @Override
    KindFlatDto map(CsvVehicleRegistrationRecordDto source);
}
