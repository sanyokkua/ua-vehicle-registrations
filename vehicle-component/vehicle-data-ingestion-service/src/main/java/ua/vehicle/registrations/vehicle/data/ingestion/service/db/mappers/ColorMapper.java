package ua.vehicle.registrations.vehicle.data.ingestion.service.db.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.entities.Color;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.mappers.abstraction.BaseCsvVehicleRegistrationRecordMapper;
import ua.vehicle.registrations.vehicle.data.ingestion.service.dto.CsvVehicleRegistrationRecordDto;

@Mapper(componentModel = "spring")
public interface ColorMapper extends BaseCsvVehicleRegistrationRecordMapper<Color> {

    @Mapping(source = "colorName", target = "colorName", defaultValue = "N/A")
    @Override
    Color map(CsvVehicleRegistrationRecordDto source);
}
