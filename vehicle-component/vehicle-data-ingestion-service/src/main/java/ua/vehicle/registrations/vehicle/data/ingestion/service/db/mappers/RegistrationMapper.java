package ua.vehicle.registrations.vehicle.data.ingestion.service.db.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.entities.Registration;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.mappers.abstraction.BaseCsvVehicleRegistrationRecordMapper;
import ua.vehicle.registrations.vehicle.data.ingestion.service.dto.CsvVehicleRegistrationRecordDto;

@Mapper(componentModel = "spring")
public interface RegistrationMapper extends BaseCsvVehicleRegistrationRecordMapper<Registration> {

    @Mapping(source = "personType", target = "personType")
    @Mapping(source = "personRegistrationAddress", target = "personRegAddress", defaultValue = "N/A")
    @Mapping(source = "registrationDate", target = "regDate")
    @Mapping(source = "registrationNumber", target = "regNumber", defaultValue = "N/A")
    @Mapping(source = "vinNumber", target = "vinNumber", defaultValue = "N/A")
    @Mapping(source = "colorName", target = "colorName")
    @Mapping(source = "opCode", target = "opCode")
    @Mapping(source = "depCode", target = "depCode")
    @Override
    Registration map(CsvVehicleRegistrationRecordDto source);
}
