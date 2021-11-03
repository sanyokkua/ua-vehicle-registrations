package ua.vehicle.registrations.vehicle.management.repository.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ua.vehicle.registrations.vehicle.management.repository.db.repositories.BodyRepository;
import ua.vehicle.registrations.vehicle.management.repository.utils.SpecificationUtils;
import ua.vehicle.registrations.vehicle.management.repository.db.jpa.BodyEntity;
import ua.vehicle.registrations.dto.searchable.BodySearchableDto;

import java.util.Optional;

@Slf4j
@Service
public class BodyService extends BaseService<BodySearchableDto, BodyEntity, String> {

    @Autowired
    public BodyService(SpecificationUtils<BodyEntity> specificationUtils, BodyRepository repository) {
        super(specificationUtils, repository);
    }

    @Override
    public Optional<Specification<BodyEntity>> getSpecification(BodySearchableDto searchObject) {
        var bodyType = searchObject.getBodyType();
        return buildSpecification(createBaseSpecsForString(bodyType, "bodyType"));
    }
}
