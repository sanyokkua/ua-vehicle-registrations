package ua.vehicle.registrations.service.dto.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.vehicle.registrations.dto.flat.DepartmentFlatDto;
import ua.vehicle.registrations.mappers.InputMapper;
import ua.vehicle.registrations.service.db.entities.DepartmentEntity;

@Mapper(componentModel = "spring")
public interface DepartmentJpaToFlatMapper extends InputMapper<DepartmentEntity, DepartmentFlatDto> {

    @Mapping(source = "depCode", target = "depCode")
    @Mapping(source = "depName", target = "depName")
    @Override
    DepartmentFlatDto map(DepartmentEntity source);
}
