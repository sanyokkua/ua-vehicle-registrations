package ua.vehicle.registrations.service.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ua.vehicle.registrations.dto.flat.BodyFlatDto;
import ua.vehicle.registrations.dto.searchable.BodySearchableDto;
import ua.vehicle.registrations.mappers.InputMapper;
import ua.vehicle.registrations.service.api.BaseRepository;
import ua.vehicle.registrations.service.db.entities.BodyEntity;
import ua.vehicle.registrations.service.utils.SpecificationUtils;

import java.util.Optional;

@Slf4j
@Service
public class BodyService extends BaseService<BodySearchableDto, BodyFlatDto, BodyEntity, String> {

    @Autowired
    public BodyService(SpecificationUtils<BodyEntity> specificationUtils,
            BaseRepository<BodyEntity, String> repository,
            InputMapper<BodyEntity, BodyFlatDto> mapper
    ) {
        super(specificationUtils, repository, mapper);
    }

    @Override
    public Optional<Specification<BodyEntity>> getSpecification(BodySearchableDto searchObject) {
        var bodyType = searchObject.getBodyType();
        return buildSpecification(createBaseSpecsForString(bodyType, "bodyType"));
    }
}
