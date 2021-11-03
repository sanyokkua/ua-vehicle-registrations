package ua.vehicle.registrations.vehicle.data.ingestion.service.db.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.vehicle.registrations.dto.flat.BrandFlatDto;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.mappers.abstraction.BaseCsvVehicleRegistrationRecordMapper;
import ua.vehicle.registrations.vehicle.data.ingestion.service.dto.CsvVehicleRegistrationRecordDto;

@Mapper(componentModel = "spring")
public interface BrandMapper extends BaseCsvVehicleRegistrationRecordMapper<BrandFlatDto> {

    @Mapping(source = "brandName", target = "brandName", defaultValue = "N/A")
    @Override
    BrandFlatDto map(CsvVehicleRegistrationRecordDto source);
}