package ua.vehicle.registrations.vehicle.service.mappers.flat;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.vehicle.registrations.vehicle.service.dto.flat.BrandFlatDto;
import ua.vehicle.registrations.vehicle.service.dto.jpa.BrandEntity;
import ua.vehicle.registrations.vehicle.service.mappers.InputMapper;

@Mapper(componentModel = "spring")
public interface BrandJpaToFlatMapper extends InputMapper<BrandEntity, BrandFlatDto> {

    @Mapping(source = "brandName", target = "brandName")
    @Override
    BrandFlatDto map(BrandEntity source);
}
