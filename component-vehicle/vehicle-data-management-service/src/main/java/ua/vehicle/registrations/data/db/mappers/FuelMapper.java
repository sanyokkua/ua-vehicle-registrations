package ua.vehicle.registrations.data.db.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.vehicle.registrations.data.db.mappers.abstraction.BaseCsvVehicleRegistrationRecordMapper;
import ua.vehicle.registrations.data.dto.CsvVehicleRegistrationRecordDto;
import ua.vehicle.registrations.dto.flat.FuelFlatDto;

@Mapper(componentModel = "spring")
public interface FuelMapper extends BaseCsvVehicleRegistrationRecordMapper<FuelFlatDto> {

    @Mapping(source = "fuelType", target = "fuelType", defaultValue = "N/A")
    @Override
    FuelFlatDto map(CsvVehicleRegistrationRecordDto source);
}
