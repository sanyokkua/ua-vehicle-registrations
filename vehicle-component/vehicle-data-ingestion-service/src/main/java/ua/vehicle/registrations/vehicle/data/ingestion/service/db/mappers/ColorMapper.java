package ua.vehicle.registrations.vehicle.data.ingestion.service.db.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.mappers.abstraction.BaseCsvVehicleRegistrationRecordMapper;
import ua.vehicle.registrations.vehicle.data.ingestion.service.dto.CsvVehicleRegistrationRecordDto;
import ua.vehicle.registrations.vehicle.service.dto.flat.ColorFlatDto;

@Mapper(componentModel = "spring")
public interface ColorMapper extends BaseCsvVehicleRegistrationRecordMapper<ColorFlatDto> {

    @Mapping(source = "colorName", target = "colorName", defaultValue = "N/A")
    @Override
    ColorFlatDto map(CsvVehicleRegistrationRecordDto source);
}
