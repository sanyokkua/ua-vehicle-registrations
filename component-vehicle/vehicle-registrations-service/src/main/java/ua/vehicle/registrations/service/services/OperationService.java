package ua.vehicle.registrations.service.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ua.vehicle.registrations.dto.flat.OperationFlatDto;
import ua.vehicle.registrations.dto.searchable.OperationSearchableDto;
import ua.vehicle.registrations.mappers.InputMapper;
import ua.vehicle.registrations.service.api.BaseRepository;
import ua.vehicle.registrations.service.db.entities.OperationEntity;
import ua.vehicle.registrations.service.utils.SpecificationUtils;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
public class OperationService extends BaseService<OperationSearchableDto, OperationFlatDto, OperationEntity, Long> {

    @Autowired
    public OperationService(SpecificationUtils<OperationEntity> specificationUtils,
            BaseRepository<OperationEntity, Long> repository,
            InputMapper<OperationEntity, OperationFlatDto> mapper
    ) {
        super(specificationUtils, repository, mapper);
    }

    @Override
    public Optional<Specification<OperationEntity>> getSpecification(OperationSearchableDto searchObject) {
        var opCode = searchObject.getOpCode();
        var opName = searchObject.getOpName();
        return buildSpecification(Stream.concat(createBaseSpecsForLong(opCode, "opCode").stream(),
                        createBaseSpecsForString(opName, "opName").stream()
                )
                .collect(Collectors.toList()));
    }
}
