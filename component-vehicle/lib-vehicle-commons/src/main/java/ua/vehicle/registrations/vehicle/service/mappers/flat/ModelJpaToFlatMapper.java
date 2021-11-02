package ua.vehicle.registrations.vehicle.service.mappers.flat;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.vehicle.registrations.vehicle.service.dto.flat.ModelFlatDto;
import ua.vehicle.registrations.vehicle.service.dto.jpa.ModelEntity;
import ua.vehicle.registrations.vehicle.service.mappers.InputMapper;

@Mapper(componentModel = "spring")
public interface ModelJpaToFlatMapper extends InputMapper<ModelEntity, ModelFlatDto> {

    @Mapping(source = "modelName", target = "modelName")
    @Override
    ModelFlatDto map(ModelEntity source);
}
