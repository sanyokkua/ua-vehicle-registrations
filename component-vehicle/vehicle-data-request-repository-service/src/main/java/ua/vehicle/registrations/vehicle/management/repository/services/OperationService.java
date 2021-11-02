package ua.vehicle.registrations.vehicle.management.repository.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ua.vehicle.registrations.vehicle.management.repository.repositories.OperationRepository;
import ua.vehicle.registrations.vehicle.management.repository.utils.SpecificationUtils;
import ua.vehicle.registrations.vehicle.service.dto.jpa.OperationEntity;
import ua.vehicle.registrations.vehicle.service.dto.searchable.OperationSearchableDto;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
public class OperationService extends BaseService<OperationSearchableDto, OperationEntity, Long> {

    @Autowired
    public OperationService(SpecificationUtils<OperationEntity> specificationUtils, OperationRepository repository) {
        super(specificationUtils, repository);
    }

    @Override
    public Optional<Specification<OperationEntity>> getSpecification(OperationSearchableDto searchObject) {
        var opCode = searchObject.getOpCode();
        var opName = searchObject.getOpName();
        return buildSpecification(Stream.concat(
                        createBaseSpecsForLong(opCode, "opCode").stream(),
                        createBaseSpecsForString(opName, "opName").stream())
                .collect(Collectors.toList()));
    }
}
