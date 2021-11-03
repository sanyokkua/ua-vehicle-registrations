package ua.vehicle.registrations.vehicle.data.ingestion.service.db.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.vehicle.registrations.dto.flat.ModelFlatDto;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.mappers.abstraction.BaseCsvVehicleRegistrationRecordMapper;
import ua.vehicle.registrations.vehicle.data.ingestion.service.dto.CsvVehicleRegistrationRecordDto;

@Mapper(componentModel = "spring")
public interface ModelMapper extends BaseCsvVehicleRegistrationRecordMapper<ModelFlatDto> {

    @Mapping(source = "modelName", target = "modelName", defaultValue = "N/A")
    @Override
    ModelFlatDto map(CsvVehicleRegistrationRecordDto source);
}
