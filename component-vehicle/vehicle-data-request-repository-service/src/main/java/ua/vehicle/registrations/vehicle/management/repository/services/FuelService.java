package ua.vehicle.registrations.vehicle.management.repository.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ua.vehicle.registrations.vehicle.management.repository.db.repositories.FuelRepository;
import ua.vehicle.registrations.vehicle.management.repository.utils.SpecificationUtils;
import ua.vehicle.registrations.vehicle.management.repository.db.jpa.FuelEntity;
import ua.vehicle.registrations.dto.searchable.FuelSearchableDto;

import java.util.Optional;

@Slf4j
@Service
public class FuelService extends BaseService<FuelSearchableDto, FuelEntity, String> {

    @Autowired
    public FuelService(SpecificationUtils<FuelEntity> specificationUtils, FuelRepository repository) {
        super(specificationUtils, repository);
    }

    @Override
    public Optional<Specification<FuelEntity>> getSpecification(FuelSearchableDto searchObject) {
        var fuelType = searchObject.getFuelType();
        return buildSpecification(createBaseSpecsForString(fuelType, "fuelType"));
    }
}
