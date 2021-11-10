package ua.vehicle.registrations.data.db.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.vehicle.registrations.data.db.mappers.abstraction.BaseCsvVehicleRegistrationRecordMapper;
import ua.vehicle.registrations.data.dto.CsvVehicleRegistrationRecordDto;
import ua.vehicle.registrations.dto.flat.ColorFlatDto;

@Mapper(componentModel = "spring")
public interface ColorMapper extends BaseCsvVehicleRegistrationRecordMapper<ColorFlatDto> {

    @Mapping(source = "colorName", target = "colorName", defaultValue = "N/A")
    @Override
    ColorFlatDto map(CsvVehicleRegistrationRecordDto source);
}
