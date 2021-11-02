package ua.vehicle.registrations.vehicle.service.mappers.flat;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.vehicle.registrations.vehicle.service.dto.flat.RegistrationFlatDto;
import ua.vehicle.registrations.vehicle.service.dto.jpa.RegistrationEntity;
import ua.vehicle.registrations.vehicle.service.mappers.InputMapper;

@Mapper(componentModel = "spring")
public interface RegistrationJpaToFlatMapper extends InputMapper<RegistrationEntity, RegistrationFlatDto> {

    @Mapping(source = "personType", target = "personType")
    @Mapping(source = "personRegAddress", target = "personRegAddress", defaultValue = "N/A")
    @Mapping(source = "regDate", target = "regDate")
    @Mapping(source = "regNumber", target = "regNumber", defaultValue = "N/A")
    @Mapping(source = "vinNumber", target = "vinNumber", defaultValue = "N/A")
    @Mapping(source = "color.colorName", target = "colorName")
    @Mapping(source = "operation.opCode", target = "opCode")
    @Mapping(source = "operation.opName", target = "opName")
    @Mapping(source = "department.depCode", target = "depCode")
    @Mapping(source = "department.depName", target = "depName")
    @Mapping(source = "vehicle.brand.brandName", target = "brandName")
    @Mapping(source = "vehicle.model.modelName", target = "modelName")
    @Mapping(source = "vehicle.body.bodyType", target = "bodyType")
    @Mapping(source = "vehicle.kind.kindName", target = "kindName")
    @Mapping(source = "vehicle.fuel.fuelType", target = "fuelType", defaultValue = "N/A")
    @Mapping(source = "vehicle.purpose.purposeName", target = "purposeName")
    @Mapping(source = "vehicle.engineCapacity", target = "engineCapacity", defaultValue = "0")
    @Mapping(source = "vehicle.makeYear", target = "makeYear")
    @Mapping(source = "vehicle.ownWeight", target = "ownWeight", defaultValue = "0")
    @Mapping(source = "vehicle.totalWeight", target = "totalWeight", defaultValue = "0")
    @Override
    RegistrationFlatDto map(RegistrationEntity source);
}
