package ua.vehicle.registrations.vehicle.service.mappers.flat;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.vehicle.registrations.vehicle.service.dto.flat.DepartmentFlatDto;
import ua.vehicle.registrations.vehicle.service.dto.jpa.DepartmentEntity;
import ua.vehicle.registrations.vehicle.service.mappers.InputMapper;

@Mapper(componentModel = "spring")
public interface DepartmentJpaToFlatMapper extends InputMapper<DepartmentEntity, DepartmentFlatDto> {

    @Mapping(source = "depCode", target = "depCode")
    @Mapping(source = "depName", target = "depName")
    @Override
    DepartmentFlatDto map(DepartmentEntity source);
}
