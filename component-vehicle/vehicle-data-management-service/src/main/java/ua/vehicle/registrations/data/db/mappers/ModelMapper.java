package ua.vehicle.registrations.data.db.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.vehicle.registrations.data.db.mappers.abstraction.BaseCsvVehicleRegistrationRecordMapper;
import ua.vehicle.registrations.data.dto.CsvVehicleRegistrationRecordDto;
import ua.vehicle.registrations.dto.flat.ModelFlatDto;

@Mapper(componentModel = "spring")
public interface ModelMapper extends BaseCsvVehicleRegistrationRecordMapper<ModelFlatDto> {

    @Mapping(source = "modelName", target = "modelName", defaultValue = "N/A")
    @Override
    ModelFlatDto map(CsvVehicleRegistrationRecordDto source);
}
