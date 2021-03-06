package ua.vehicle.registrations.service.dto.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.vehicle.registrations.dto.flat.KindFlatDto;
import ua.vehicle.registrations.mappers.InputMapper;
import ua.vehicle.registrations.service.db.entities.KindEntity;

@Mapper(componentModel = "spring")
public interface KindJpaToFlatMapper extends InputMapper<KindEntity, KindFlatDto> {

    @Mapping(source = "kindName", target = "kindName")
    @Override
    KindFlatDto map(KindEntity source);
}
