package ua.vehicle.registrations.vehicle.service.mappers.flat;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.vehicle.registrations.dto.flat.DepartmentFlatDto;
import ua.vehicle.registrations.mappers.InputMapper;
import ua.vehicle.registrations.vehicle.service.dto.jpa.DepartmentEntity;

@Mapper(componentModel = "spring")
public interface DepartmentJpaToFlatMapper extends InputMapper<DepartmentEntity, DepartmentFlatDto> {

    @Mapping(source = "depCode", target = "depCode")
    @Mapping(source = "depName", target = "depName")
    @Override
    DepartmentFlatDto map(DepartmentEntity source);
}
