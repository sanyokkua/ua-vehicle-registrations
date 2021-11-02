package ua.vehicle.registrations.vehicle.management.repository.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ua.vehicle.registrations.vehicle.management.repository.repositories.DepartmentRepository;
import ua.vehicle.registrations.vehicle.management.repository.utils.SpecificationUtils;
import ua.vehicle.registrations.vehicle.service.dto.jpa.DepartmentEntity;
import ua.vehicle.registrations.vehicle.service.dto.searchable.DepartmentSearchableDto;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
public class DepartmentService extends BaseService<DepartmentSearchableDto, DepartmentEntity, Long> {

    @Autowired
    public DepartmentService(SpecificationUtils<DepartmentEntity> specificationUtils, DepartmentRepository repository) {
        super(specificationUtils, repository);
    }

    @Override
    public Optional<Specification<DepartmentEntity>> getSpecification(DepartmentSearchableDto searchObject) {
        var depCode = searchObject.getDepCode();
        var depName = searchObject.getDepName();
        return buildSpecification(Stream.concat(
                        createBaseSpecsForString(depName, "depName").stream(),
                        createBaseSpecsForLong(depCode, "depCode").stream())
                .collect(Collectors.toList()));
    }
}
