package ua.vehicle.registrations.data.db.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.vehicle.registrations.data.db.mappers.abstraction.BaseCsvVehicleRegistrationRecordMapper;
import ua.vehicle.registrations.data.dto.CsvVehicleRegistrationRecordDto;
import ua.vehicle.registrations.dto.flat.OperationFlatDto;

@Mapper(componentModel = "spring")
public interface OperationMapper extends BaseCsvVehicleRegistrationRecordMapper<OperationFlatDto> {

    @Mapping(source = "opCode", target = "opCode")
    @Mapping(source = "opName", target = "opName")
    @Override
    OperationFlatDto map(CsvVehicleRegistrationRecordDto source);
}
