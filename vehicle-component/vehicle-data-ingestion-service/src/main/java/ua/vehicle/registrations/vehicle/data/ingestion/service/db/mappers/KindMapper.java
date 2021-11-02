package ua.vehicle.registrations.vehicle.data.ingestion.service.db.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.mappers.abstraction.BaseCsvVehicleRegistrationRecordMapper;
import ua.vehicle.registrations.vehicle.data.ingestion.service.dto.CsvVehicleRegistrationRecordDto;
import ua.vehicle.registrations.vehicle.service.dto.flat.KindFlatDto;

@Mapper(componentModel = "spring")
public interface KindMapper extends BaseCsvVehicleRegistrationRecordMapper<KindFlatDto> {

    @Mapping(source = "kindName", target = "kindName", defaultValue = "N/A")
    @Override
    KindFlatDto map(CsvVehicleRegistrationRecordDto source);
}
