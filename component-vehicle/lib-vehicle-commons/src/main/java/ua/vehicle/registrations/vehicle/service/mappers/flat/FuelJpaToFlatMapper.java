package ua.vehicle.registrations.vehicle.service.mappers.flat;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.vehicle.registrations.vehicle.service.dto.flat.FuelFlatDto;
import ua.vehicle.registrations.vehicle.service.dto.jpa.FuelEntity;
import ua.vehicle.registrations.vehicle.service.mappers.InputMapper;

@Mapper(componentModel = "spring")
public interface FuelJpaToFlatMapper extends InputMapper<FuelEntity, FuelFlatDto> {

    @Mapping(source = "fuelType", target = "fuelType")
    @Override
    FuelFlatDto map(FuelEntity source);
}
