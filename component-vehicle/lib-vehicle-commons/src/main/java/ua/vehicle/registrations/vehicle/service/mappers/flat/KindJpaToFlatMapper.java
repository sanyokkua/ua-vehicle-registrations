package ua.vehicle.registrations.vehicle.service.mappers.flat;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.vehicle.registrations.vehicle.service.dto.flat.KindFlatDto;
import ua.vehicle.registrations.vehicle.service.dto.jpa.KindEntity;
import ua.vehicle.registrations.vehicle.service.mappers.InputMapper;

@Mapper(componentModel = "spring")
public interface KindJpaToFlatMapper extends InputMapper<KindEntity, KindFlatDto> {

    @Mapping(source = "kindName", target = "kindName")
    @Override
    KindFlatDto map(KindEntity source);
}
