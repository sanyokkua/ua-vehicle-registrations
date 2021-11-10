package ua.vehicle.registrations.service.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ua.vehicle.registrations.dto.flat.FuelFlatDto;
import ua.vehicle.registrations.dto.searchable.FuelSearchableDto;
import ua.vehicle.registrations.mappers.InputMapper;
import ua.vehicle.registrations.service.api.BaseRepository;
import ua.vehicle.registrations.service.db.entities.FuelEntity;
import ua.vehicle.registrations.service.utils.SpecificationUtils;

import java.util.Optional;

@Slf4j
@Service
public class FuelService extends BaseService<FuelSearchableDto, FuelFlatDto, FuelEntity, String> {

    @Autowired
    public FuelService(SpecificationUtils<FuelEntity> specificationUtils,
            BaseRepository<FuelEntity, String> repository,
            InputMapper<FuelEntity, FuelFlatDto> mapper
    ) {
        super(specificationUtils, repository, mapper);
    }

    @Override
    public Optional<Specification<FuelEntity>> getSpecification(FuelSearchableDto searchObject) {
        var fuelType = searchObject.getFuelType();
        return buildSpecification(createBaseSpecsForString(fuelType, "fuelType"));
    }
}
