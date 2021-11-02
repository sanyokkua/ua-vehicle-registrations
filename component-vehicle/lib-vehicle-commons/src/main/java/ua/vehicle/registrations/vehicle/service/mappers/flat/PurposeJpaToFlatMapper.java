package ua.vehicle.registrations.vehicle.service.mappers.flat;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.vehicle.registrations.vehicle.service.dto.flat.PurposeFlatDto;
import ua.vehicle.registrations.vehicle.service.dto.jpa.PurposeEntity;
import ua.vehicle.registrations.vehicle.service.mappers.InputMapper;

@Mapper(componentModel = "spring")
public interface PurposeJpaToFlatMapper extends InputMapper<PurposeEntity, PurposeFlatDto> {

    @Mapping(source = "purposeName", target = "purposeName")
    @Override
    PurposeFlatDto map(PurposeEntity source);
}
