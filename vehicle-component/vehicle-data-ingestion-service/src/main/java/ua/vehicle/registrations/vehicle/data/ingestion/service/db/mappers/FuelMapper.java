package ua.vehicle.registrations.vehicle.data.ingestion.service.db.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.entities.Fuel;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.mappers.abstraction.BaseCsvVehicleRegistrationRecordMapper;
import ua.vehicle.registrations.vehicle.data.ingestion.service.dto.CsvVehicleRegistrationRecordDto;

@Mapper(componentModel = "spring")
public interface FuelMapper extends BaseCsvVehicleRegistrationRecordMapper<Fuel> {

    @Mapping(source = "fuelType", target = "fuelType", defaultValue = "N/A")
    @Override
    Fuel map(CsvVehicleRegistrationRecordDto source);
}
