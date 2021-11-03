package ua.vehicle.registrations.vehicle.management.repository.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ua.vehicle.registrations.vehicle.management.repository.db.repositories.PurposeRepository;
import ua.vehicle.registrations.vehicle.management.repository.utils.SpecificationUtils;
import ua.vehicle.registrations.vehicle.management.repository.db.jpa.PurposeEntity;
import ua.vehicle.registrations.dto.searchable.PurposeSearchableDto;

import java.util.Optional;

@Slf4j
@Service
public class PurposeService extends BaseService<PurposeSearchableDto, PurposeEntity, String> {

    @Autowired
    public PurposeService(SpecificationUtils<PurposeEntity> specificationUtils, PurposeRepository repository) {
        super(specificationUtils, repository);
    }

    @Override
    public Optional<Specification<PurposeEntity>> getSpecification(PurposeSearchableDto searchObject) {
        var purposeName = searchObject.getPurposeName();
        return buildSpecification(createBaseSpecsForString(purposeName, "purposeName"));
    }
}
