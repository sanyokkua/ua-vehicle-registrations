package ua.vehicle.registrations.vehicle.service.mappers.flat;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.vehicle.registrations.vehicle.service.dto.flat.OperationFlatDto;
import ua.vehicle.registrations.vehicle.service.dto.jpa.OperationEntity;
import ua.vehicle.registrations.vehicle.service.mappers.InputMapper;

@Mapper(componentModel = "spring")
public interface OperationJpaToFlatMapper extends InputMapper<OperationEntity, OperationFlatDto> {

    @Mapping(source = "opCode", target = "opCode")
    @Mapping(source = "opName", target = "opName")
    @Override
    OperationFlatDto map(OperationEntity source);
}
