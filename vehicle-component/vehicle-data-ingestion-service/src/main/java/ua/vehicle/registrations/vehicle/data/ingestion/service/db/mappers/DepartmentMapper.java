package ua.vehicle.registrations.vehicle.data.ingestion.service.db.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.entities.Department;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.mappers.abstraction.BaseCsvVehicleRegistrationRecordMapper;
import ua.vehicle.registrations.vehicle.data.ingestion.service.dto.CsvVehicleRegistrationRecordDto;

@Mapper(componentModel = "spring")
public interface DepartmentMapper extends BaseCsvVehicleRegistrationRecordMapper<Department> {

    @Mapping(source = "depCode", target = "depCode")
    @Mapping(source = "depName", target = "depName")
    @Override
    Department map(CsvVehicleRegistrationRecordDto source);
}
