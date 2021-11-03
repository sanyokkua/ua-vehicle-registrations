package ua.vehicle.registrations.vehicle.service.mappers.flat;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.vehicle.registrations.dto.flat.ModelFlatDto;
import ua.vehicle.registrations.mappers.InputMapper;
import ua.vehicle.registrations.vehicle.service.dto.jpa.ModelEntity;

@Mapper(componentModel = "spring")
public interface ModelJpaToFlatMapper extends InputMapper<ModelEntity, ModelFlatDto> {

    @Mapping(source = "modelName", target = "modelName")
    @Override
    ModelFlatDto map(ModelEntity source);
}
