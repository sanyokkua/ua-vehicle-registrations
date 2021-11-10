package ua.vehicle.registrations.service.dto.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.vehicle.registrations.dto.flat.BodyFlatDto;
import ua.vehicle.registrations.mappers.InputMapper;
import ua.vehicle.registrations.service.db.entities.BodyEntity;

@Mapper(componentModel = "spring")
public interface BodyJpaToFlatMapper extends InputMapper<BodyEntity, BodyFlatDto> {

    @Mapping(source = "bodyType", target = "bodyType")
    @Override
    BodyFlatDto map(BodyEntity source);
}
