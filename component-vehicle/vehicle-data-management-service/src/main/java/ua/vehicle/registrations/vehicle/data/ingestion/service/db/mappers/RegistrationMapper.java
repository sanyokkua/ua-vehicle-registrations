package ua.vehicle.registrations.vehicle.data.ingestion.service.db.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.vehicle.registrations.dto.flat.RegistrationFlatDto;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.mappers.abstraction.BaseCsvVehicleRegistrationRecordMapper;
import ua.vehicle.registrations.vehicle.data.ingestion.service.dto.CsvVehicleRegistrationRecordDto;

@Mapper(componentModel = "spring")
public interface RegistrationMapper extends BaseCsvVehicleRegistrationRecordMapper<RegistrationFlatDto> {

    @Mapping(source = "personType", target = "personType")
    @Mapping(source = "personRegistrationAddress", target = "personRegAddress", defaultValue = "N/A")
    @Mapping(source = "registrationDate", target = "regDate")
    @Mapping(source = "registrationNumber", target = "regNumber", defaultValue = "N/A")
    @Mapping(source = "vinNumber", target = "vinNumber", defaultValue = "N/A")
    @Mapping(source = "colorName", target = "colorName")
    @Mapping(source = "opCode", target = "opCode")
    @Mapping(source = "depCode", target = "depCode")
    @Mapping(source = "brandName", target = "brandName")
    @Mapping(source = "modelName", target = "modelName")
    @Mapping(source = "bodyType", target = "bodyType")
    @Mapping(source = "kindName", target = "kindName")
    @Mapping(source = "fuelType", target = "fuelType", defaultValue = "N/A")
    @Mapping(source = "purposeName", target = "purposeName")
    @Mapping(source = "engineCapacity", target = "engineCapacity", defaultValue = "0L")
    @Mapping(source = "makeYear", target = "makeYear")
    @Mapping(source = "ownWeight", target = "ownWeight", defaultValue = "0L")
    @Mapping(source = "totalWeight", target = "totalWeight", defaultValue = "0L")
    @Override
    RegistrationFlatDto map(CsvVehicleRegistrationRecordDto source);
}
