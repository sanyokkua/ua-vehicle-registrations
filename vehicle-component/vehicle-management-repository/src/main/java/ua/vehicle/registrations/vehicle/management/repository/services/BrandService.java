package ua.vehicle.registrations.vehicle.management.repository.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ua.vehicle.registrations.vehicle.management.repository.repositories.BrandRepository;
import ua.vehicle.registrations.vehicle.management.repository.utils.SpecificationUtils;
import ua.vehicle.registrations.vehicle.service.dto.jpa.BrandEntity;
import ua.vehicle.registrations.vehicle.service.dto.searchable.BrandSearchableDto;

import java.util.Optional;

@Slf4j
@Service
public class BrandService extends BaseService<BrandSearchableDto, BrandEntity, String> {

    @Autowired
    public BrandService(SpecificationUtils<BrandEntity> specificationUtils, BrandRepository repository) {
        super(specificationUtils, repository);
    }

    @Override
    public Optional<Specification<BrandEntity>> getSpecification(BrandSearchableDto searchObject) {
        var brandName = searchObject.getBrandName();
        return buildSpecification(createBaseSpecsForString(brandName, "brandName"));
    }
}
