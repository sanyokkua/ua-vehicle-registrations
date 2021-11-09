package ua.vehicle.registrations.service.dto.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.vehicle.registrations.dto.flat.PurposeFlatDto;
import ua.vehicle.registrations.mappers.InputMapper;
import ua.vehicle.registrations.service.db.entities.PurposeEntity;

@Mapper(componentModel = "spring")
public interface PurposeJpaToFlatMapper extends InputMapper<PurposeEntity, PurposeFlatDto> {

    @Mapping(source = "purposeName", target = "purposeName")
    @Override
    PurposeFlatDto map(PurposeEntity source);
}
