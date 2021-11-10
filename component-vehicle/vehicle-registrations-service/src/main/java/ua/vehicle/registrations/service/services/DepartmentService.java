package ua.vehicle.registrations.service.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ua.vehicle.registrations.dto.flat.DepartmentFlatDto;
import ua.vehicle.registrations.dto.searchable.DepartmentSearchableDto;
import ua.vehicle.registrations.mappers.InputMapper;
import ua.vehicle.registrations.service.api.BaseRepository;
import ua.vehicle.registrations.service.db.entities.DepartmentEntity;
import ua.vehicle.registrations.service.utils.SpecificationUtils;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
public class DepartmentService extends BaseService<DepartmentSearchableDto, DepartmentFlatDto, DepartmentEntity, Long> {

    @Autowired
    public DepartmentService(SpecificationUtils<DepartmentEntity> specificationUtils,
            BaseRepository<DepartmentEntity, Long> repository,
            InputMapper<DepartmentEntity, DepartmentFlatDto> mapper
    ) {
        super(specificationUtils, repository, mapper);
    }

    @Override
    public Optional<Specification<DepartmentEntity>> getSpecification(DepartmentSearchableDto searchObject) {
        var depCode = searchObject.getDepCode();
        var depName = searchObject.getDepName();
        return buildSpecification(Stream.concat(
                createBaseSpecsForString(depName, "depName").stream(),
                createBaseSpecsForLong(depCode, "depCode").stream()
        ).collect(Collectors.toList()));
    }
}
