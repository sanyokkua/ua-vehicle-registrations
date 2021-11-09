package ua.vehicle.registrations.service.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ua.vehicle.registrations.dto.flat.KindFlatDto;
import ua.vehicle.registrations.dto.searchable.KindSearchableDto;
import ua.vehicle.registrations.mappers.InputMapper;
import ua.vehicle.registrations.service.api.BaseRepository;
import ua.vehicle.registrations.service.db.entities.KindEntity;
import ua.vehicle.registrations.service.utils.SpecificationUtils;

import java.util.Optional;

@Slf4j
@Service
public class KindService extends BaseService<KindSearchableDto, KindFlatDto, KindEntity, String> {

    @Autowired
    public KindService(SpecificationUtils<KindEntity> specificationUtils,
            BaseRepository<KindEntity, String> repository,
            InputMapper<KindEntity, KindFlatDto> mapper
    ) {
        super(specificationUtils, repository, mapper);
    }

    @Override
    public Optional<Specification<KindEntity>> getSpecification(KindSearchableDto searchObject) {
        var kindName = searchObject.getKindName();
        return buildSpecification(createBaseSpecsForString(kindName, "kindName"));
    }
}
