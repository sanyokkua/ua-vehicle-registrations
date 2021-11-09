package ua.vehicle.registrations.service.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import ua.vehicle.registrations.dto.Field;
import ua.vehicle.registrations.exceptions.RecordIsNotFoundException;
import ua.vehicle.registrations.mappers.InputMapper;
import ua.vehicle.registrations.service.api.BaseRepository;
import ua.vehicle.registrations.service.api.BaseVehicleServiceApi;
import ua.vehicle.registrations.service.utils.SpecificationUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.springframework.data.jpa.domain.Specification.where;

@Slf4j
@RequiredArgsConstructor
public abstract class BaseService<IN, OUT, JPA, ID> implements BaseVehicleServiceApi<IN, OUT, JPA, ID> {

    protected final SpecificationUtils<JPA> specificationUtils;
    protected final BaseRepository<JPA, ID> repository;
    protected final InputMapper<JPA, OUT> mapper;

    protected Optional<Specification<JPA>> buildSpecification(List<Specification<JPA>> specs) {
        log.debug("buildSpecification started");
        if (Objects.isNull(specs) || specs.isEmpty()) {
            log.debug("buildSpecification, specs are empty, Optional.empty() will be returned");
            return Optional.empty();
        }
        var filteredSpecs = specs.stream().filter(Objects::nonNull).collect(Collectors.toList());
        if (filteredSpecs.isEmpty()) {
            log.debug("buildSpecification, filtered specs are empty, Optional.empty() will be returned");
            return Optional.empty();
        }
        Specification<JPA> specification = filteredSpecs.get(0);
        filteredSpecs.remove(specification);
        for (var spec : filteredSpecs) {
            specification = specification.and(spec);
        }
        log.debug("buildSpecification, final specs: {}", specification);
        return Optional.of(specification);
    }

    protected List<Specification<JPA>> createBaseSpecsForLong(Field<Long> field, String... path) {
        log.info("createBaseSpecsForLong, field - {}, path - {}", field, path);
        return Stream.of(
                specificationUtils.equalTo(field, path),
                specificationUtils.lessThanOrEqualTo(field, path),
                specificationUtils.greaterThanOrEqualTo(field, path)
        ).filter(Optional::isPresent).map(Optional::get).collect(Collectors.toList());
    }

    protected List<Specification<JPA>> createBaseSpecsForString(Field<String> field, String... path) {
        log.info("createBaseSpecsForString, field - {}, path - {}", field, path);
        return Stream.of(specificationUtils.equalTo(field, path), specificationUtils.likeTo(field, path))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    @Override
    public Page<OUT> findRecordsByCriteria(IN searchObject, Pageable pageable) {
        log.info("findRecordsByCriteria, searchObject - {}, pageable - {}", searchObject, pageable);
        var specification = getSpecification(searchObject);
        log.debug("findRecordsByCriteria. specification - {}", specification);
        if (specification.isPresent()) {
            var spec = specification.get();
            return repository.findAll(where(spec), pageable).map(mapper::map);
        }
        return Page.empty();
    }

    @Override
    public long countRecordsByCriteria(IN searchObject) {
        log.info("countRecordsByCriteria, searchObject - {}", searchObject);
        var specification = getSpecification(searchObject);
        log.debug("countRecordsByCriteria. specification - {}", specification);
        return specification.map(vehicleEntitySpecification -> repository.count(where(vehicleEntitySpecification)))
                .orElse(0L);
    }

    @Override
    public long getNumberOfAllRecords() {
        log.info("getNumberOfAllRecords");
        return repository.count();
    }

    @Override
    public OUT findRecord(ID id) {
        log.info("findRecord, id - {}", id);
        return mapper.map(repository.findById(id).orElseThrow(() -> new RecordIsNotFoundException(id)));
    }
}
