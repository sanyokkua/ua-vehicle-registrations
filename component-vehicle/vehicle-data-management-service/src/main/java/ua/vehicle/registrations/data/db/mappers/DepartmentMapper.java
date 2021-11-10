package ua.vehicle.registrations.data.db.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.vehicle.registrations.data.db.mappers.abstraction.BaseCsvVehicleRegistrationRecordMapper;
import ua.vehicle.registrations.data.dto.CsvVehicleRegistrationRecordDto;
import ua.vehicle.registrations.dto.flat.DepartmentFlatDto;

@Mapper(componentModel = "spring")
public interface DepartmentMapper extends BaseCsvVehicleRegistrationRecordMapper<DepartmentFlatDto> {

    @Mapping(source = "depCode", target = "depCode")
    @Mapping(source = "depName", target = "depName")
    @Override
    DepartmentFlatDto map(CsvVehicleRegistrationRecordDto source);
}
