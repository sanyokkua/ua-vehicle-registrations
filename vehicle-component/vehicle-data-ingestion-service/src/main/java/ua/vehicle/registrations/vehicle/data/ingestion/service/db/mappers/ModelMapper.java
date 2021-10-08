package ua.vehicle.registrations.vehicle.data.ingestion.service.db.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.entities.Model;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.mappers.abstraction.BaseCsvVehicleRegistrationRecordMapper;
import ua.vehicle.registrations.vehicle.data.ingestion.service.dto.CsvVehicleRegistrationRecordDto;

@Mapper(componentModel = "spring")
public interface ModelMapper extends BaseCsvVehicleRegistrationRecordMapper<Model> {

    @Mapping(source = "modelName", target = "modelName", defaultValue = "N/A")
    @Override
    Model map(CsvVehicleRegistrationRecordDto source);
}
