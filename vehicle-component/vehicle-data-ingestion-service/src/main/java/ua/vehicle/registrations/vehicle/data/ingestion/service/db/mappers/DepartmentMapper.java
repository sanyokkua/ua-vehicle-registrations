package ua.vehicle.registrations.vehicle.data.ingestion.service.db.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.mappers.abstraction.BaseCsvVehicleRegistrationRecordMapper;
import ua.vehicle.registrations.vehicle.data.ingestion.service.dto.CsvVehicleRegistrationRecordDto;
import ua.vehicle.registrations.vehicle.service.dto.flat.DepartmentFlatDto;

@Mapper(componentModel = "spring")
public interface DepartmentMapper extends BaseCsvVehicleRegistrationRecordMapper<DepartmentFlatDto> {

    @Mapping(source = "depCode", target = "depCode")
    @Mapping(source = "depName", target = "depName")
    @Override
    DepartmentFlatDto map(CsvVehicleRegistrationRecordDto source);
}
