package ua.vehicle.registrations.vehicle.data.ingestion.service.db.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.vehicle.registrations.dto.flat.FuelFlatDto;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.mappers.abstraction.BaseCsvVehicleRegistrationRecordMapper;
import ua.vehicle.registrations.vehicle.data.ingestion.service.dto.CsvVehicleRegistrationRecordDto;

@Mapper(componentModel = "spring")
public interface FuelMapper extends BaseCsvVehicleRegistrationRecordMapper<FuelFlatDto> {

    @Mapping(source = "fuelType", target = "fuelType", defaultValue = "N/A")
    @Override
    FuelFlatDto map(CsvVehicleRegistrationRecordDto source);
}
