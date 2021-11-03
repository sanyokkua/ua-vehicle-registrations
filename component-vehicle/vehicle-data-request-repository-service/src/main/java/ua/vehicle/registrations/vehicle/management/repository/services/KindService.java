package ua.vehicle.registrations.vehicle.management.repository.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ua.vehicle.registrations.vehicle.management.repository.db.repositories.KindRepository;
import ua.vehicle.registrations.vehicle.management.repository.utils.SpecificationUtils;
import ua.vehicle.registrations.vehicle.management.repository.db.jpa.KindEntity;
import ua.vehicle.registrations.dto.searchable.KindSearchableDto;

import java.util.Optional;

@Slf4j
@Service
public class KindService extends BaseService<KindSearchableDto, KindEntity, String> {

    @Autowired
    public KindService(SpecificationUtils<KindEntity> specificationUtils, KindRepository repository) {
        super(specificationUtils, repository);
    }

    @Override
    public Optional<Specification<KindEntity>> getSpecification(KindSearchableDto searchObject) {
        var kindName = searchObject.getKindName();
        return buildSpecification(createBaseSpecsForString(kindName, "kindName"));
    }
}
