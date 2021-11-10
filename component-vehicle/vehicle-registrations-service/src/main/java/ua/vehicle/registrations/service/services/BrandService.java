package ua.vehicle.registrations.service.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ua.vehicle.registrations.dto.flat.BrandFlatDto;
import ua.vehicle.registrations.dto.searchable.BrandSearchableDto;
import ua.vehicle.registrations.mappers.InputMapper;
import ua.vehicle.registrations.service.api.BaseRepository;
import ua.vehicle.registrations.service.db.entities.BrandEntity;
import ua.vehicle.registrations.service.utils.SpecificationUtils;

import java.util.Optional;

@Slf4j
@Service
public class BrandService extends BaseService<BrandSearchableDto, BrandFlatDto, BrandEntity, String> {

    @Autowired
    public BrandService(SpecificationUtils<BrandEntity> specificationUtils,
            BaseRepository<BrandEntity, String> repository,
            InputMapper<BrandEntity, BrandFlatDto> mapper
    ) {
        super(specificationUtils, repository, mapper);
    }

    @Override
    public Optional<Specification<BrandEntity>> getSpecification(BrandSearchableDto searchObject) {
        var brandName = searchObject.getBrandName();
        return buildSpecification(createBaseSpecsForString(brandName, "brandName"));
    }
}
