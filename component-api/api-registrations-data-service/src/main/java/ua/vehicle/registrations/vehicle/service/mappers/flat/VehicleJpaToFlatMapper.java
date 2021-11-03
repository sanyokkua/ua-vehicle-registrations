package ua.vehicle.registrations.vehicle.service.mappers.flat;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.vehicle.registrations.dto.flat.VehicleFlatDto;
import ua.vehicle.registrations.mappers.InputMapper;
import ua.vehicle.registrations.vehicle.service.dto.jpa.VehicleEntity;

@Mapper(componentModel = "spring")
public interface VehicleJpaToFlatMapper extends InputMapper<VehicleEntity, VehicleFlatDto> {

    @Mapping(source = "brand.brandName", target = "brandName")
    @Mapping(source = "model.modelName", target = "modelName")
    @Mapping(source = "body.bodyType", target = "bodyType")
    @Mapping(source = "kind.kindName", target = "kindName")
    @Mapping(source = "fuel.fuelType", target = "fuelType", defaultValue = "N/A")
    @Mapping(source = "purpose.purposeName", target = "purposeName")
    @Mapping(source = "engineCapacity", target = "engineCapacity", defaultValue = "0")
    @Mapping(source = "makeYear", target = "makeYear")
    @Mapping(source = "ownWeight", target = "ownWeight", defaultValue = "0")
    @Mapping(source = "totalWeight", target = "totalWeight", defaultValue = "0")
    @Override
    VehicleFlatDto map(VehicleEntity source);
}
