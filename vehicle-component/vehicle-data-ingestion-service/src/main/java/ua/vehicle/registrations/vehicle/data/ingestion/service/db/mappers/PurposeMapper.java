package ua.vehicle.registrations.vehicle.data.ingestion.service.db.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.entities.Purpose;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.mappers.abstraction.BaseCsvVehicleRegistrationRecordMapper;
import ua.vehicle.registrations.vehicle.data.ingestion.service.dto.CsvVehicleRegistrationRecordDto;

@Mapper(componentModel = "spring")
public interface PurposeMapper extends BaseCsvVehicleRegistrationRecordMapper<Purpose> {

    @Mapping(source = "purposeName", target = "purposeName", defaultValue = "N/A")
    @Override
    Purpose map(CsvVehicleRegistrationRecordDto source);
}
