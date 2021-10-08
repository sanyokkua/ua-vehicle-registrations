package ua.vehicle.registrations.vehicle.data.ingestion.service.db.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.entities.Brand;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.mappers.abstraction.BaseCsvVehicleRegistrationRecordMapper;
import ua.vehicle.registrations.vehicle.data.ingestion.service.dto.CsvVehicleRegistrationRecordDto;

@Mapper(componentModel = "spring")
public interface BrandMapper extends BaseCsvVehicleRegistrationRecordMapper<Brand> {

    @Mapping(source = "brandName", target = "brandName", defaultValue = "N/A")
    @Override
    Brand map(CsvVehicleRegistrationRecordDto source);
}
