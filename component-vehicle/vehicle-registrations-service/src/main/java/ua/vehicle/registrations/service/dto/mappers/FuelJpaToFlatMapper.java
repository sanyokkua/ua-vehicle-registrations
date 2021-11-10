package ua.vehicle.registrations.service.dto.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.vehicle.registrations.dto.flat.FuelFlatDto;
import ua.vehicle.registrations.mappers.InputMapper;
import ua.vehicle.registrations.service.db.entities.FuelEntity;

@Mapper(componentModel = "spring")
public interface FuelJpaToFlatMapper extends InputMapper<FuelEntity, FuelFlatDto> {

    @Mapping(source = "fuelType", target = "fuelType")
    @Override
    FuelFlatDto map(FuelEntity source);
}
