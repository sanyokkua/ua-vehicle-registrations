package ua.vehicle.registrations.vehicle.service.mappers.flat;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.vehicle.registrations.dto.flat.ColorFlatDto;
import ua.vehicle.registrations.mappers.InputMapper;
import ua.vehicle.registrations.vehicle.service.dto.jpa.ColorEntity;

@Mapper(componentModel = "spring")
public interface ColorJpaToFlatMapper extends InputMapper<ColorEntity, ColorFlatDto> {

    @Mapping(source = "colorName", target = "colorName")
    @Override
    ColorFlatDto map(ColorEntity source);
}
