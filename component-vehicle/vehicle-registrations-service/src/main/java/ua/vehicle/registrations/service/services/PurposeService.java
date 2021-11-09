package ua.vehicle.registrations.service.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ua.vehicle.registrations.dto.flat.PurposeFlatDto;
import ua.vehicle.registrations.dto.searchable.PurposeSearchableDto;
import ua.vehicle.registrations.mappers.InputMapper;
import ua.vehicle.registrations.service.api.BaseRepository;
import ua.vehicle.registrations.service.db.entities.PurposeEntity;
import ua.vehicle.registrations.service.utils.SpecificationUtils;

import java.util.Optional;

@Slf4j
@Service
public class PurposeService extends BaseService<PurposeSearchableDto, PurposeFlatDto, PurposeEntity, String> {

    @Autowired
    public PurposeService(SpecificationUtils<PurposeEntity> specificationUtils,
            BaseRepository<PurposeEntity, String> repository,
            InputMapper<PurposeEntity, PurposeFlatDto> mapper
    ) {
        super(specificationUtils, repository, mapper);
    }

    @Override
    public Optional<Specification<PurposeEntity>> getSpecification(PurposeSearchableDto searchObject) {
        var purposeName = searchObject.getPurposeName();
        return buildSpecification(createBaseSpecsForString(purposeName, "purposeName"));
    }
}
