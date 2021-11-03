package ua.vehicle.registrations.vehicle.service.mappers.flat;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.vehicle.registrations.dto.flat.OperationFlatDto;
import ua.vehicle.registrations.mappers.InputMapper;
import ua.vehicle.registrations.vehicle.service.dto.jpa.OperationEntity;

@Mapper(componentModel = "spring")
public interface OperationJpaToFlatMapper extends InputMapper<OperationEntity, OperationFlatDto> {

    @Mapping(source = "opCode", target = "opCode")
    @Mapping(source = "opName", target = "opName")
    @Override
    OperationFlatDto map(OperationEntity source);
}
