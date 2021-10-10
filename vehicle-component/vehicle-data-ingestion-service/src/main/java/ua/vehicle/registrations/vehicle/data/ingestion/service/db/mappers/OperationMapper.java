package ua.vehicle.registrations.vehicle.data.ingestion.service.db.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.entities.Operation;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.mappers.abstraction.BaseCsvVehicleRegistrationRecordMapper;
import ua.vehicle.registrations.vehicle.data.ingestion.service.dto.CsvVehicleRegistrationRecordDto;

@Mapper(componentModel = "spring")
public interface OperationMapper extends BaseCsvVehicleRegistrationRecordMapper<Operation> {

    @Mapping(source = "opCode", target = "opCode")
    @Mapping(source = "opName", target = "opName")
    @Override
    Operation map(CsvVehicleRegistrationRecordDto source);
}
