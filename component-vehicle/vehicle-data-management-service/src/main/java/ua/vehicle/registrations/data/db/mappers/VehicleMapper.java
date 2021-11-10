package ua.vehicle.registrations.data.db.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.vehicle.registrations.data.db.mappers.abstraction.BaseCsvVehicleRegistrationRecordMapper;
import ua.vehicle.registrations.data.dto.CsvVehicleRegistrationRecordDto;
import ua.vehicle.registrations.dto.flat.VehicleFlatDto;

@Mapper(componentModel = "spring")
public interface VehicleMapper extends BaseCsvVehicleRegistrationRecordMapper<VehicleFlatDto> {

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
    VehicleFlatDto map(CsvVehicleRegistrationRecordDto source);
}
