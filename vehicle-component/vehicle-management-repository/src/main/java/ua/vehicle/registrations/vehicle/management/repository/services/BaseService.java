package ua.vehicle.registrations.vehicle.management.repository.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import ua.vehicle.registrations.vehicle.management.repository.dbapi.BaseRepository;
import ua.vehicle.registrations.vehicle.management.repository.utils.SpecificationUtils;
import ua.vehicle.registrations.vehicle.service.api.BaseVehicleServiceApi;
import ua.vehicle.registrations.vehicle.service.api.Field;
import ua.vehicle.registrations.vehicle.service.exceptions.RecordIsNotFoundException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.springframework.data.jpa.domain.Specification.where;

@Slf4j
@RequiredArgsConstructor
public abstract class BaseService<I, O, T> implements BaseVehicleServiceApi<I, O, T> {

    protected final SpecificationUtils<O> specificationUtils;
    protected final BaseRepository<O, T> repository;

    protected Optional<Specification<O>> buildSpecification(List<Specification<O>> specs) {
        log.debug("buildSpecification started");
        if (Objects.isNull(specs) || specs.isEmpty()) {
            log.debug("buildSpecification, specs are empty, Optional.empty() will be returned");
            return Optional.empty();
        }

        var filteredSpecs = specs.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        if (filteredSpecs.isEmpty()) {
            log.debug("buildSpecification, filtered specs are empty, Optional.empty() will be returned");
            return Optional.empty();
        }
        Specification<O> specification = filteredSpecs.get(0);
        filteredSpecs.remove(specification);
        for (var spec : filteredSpecs) {
            specification = specification.and(spec);
        }
        log.debug("buildSpecification, final specs: {}", specification);
        return Optional.of(specification);
    }

    protected List<Specification<O>> createBaseSpecsForLong(Field<Long> field, String... path) {
        log.info("createBaseSpecsForLong, field - {}, path - {}", field, path);
        return Stream.of(specificationUtils.equalTo(field, path),
                specificationUtils.lessThanOrEqualTo(field, path),
                specificationUtils.greaterThanOrEqualTo(field, path)).filter(Optional::isPresent).map(Optional::get).collect(Collectors.toList());
    }

    protected List<Specification<O>> createBaseSpecsForString(Field<String> field, String... path) {
        log.info("createBaseSpecsForString, field - {}, path - {}", field, path);
        return Stream.of(specificationUtils.equalTo(field, path),
                specificationUtils.likeTo(field, path)).filter(Optional::isPresent).map(Optional::get).collect(Collectors.toList());
    }

    @Override
    public Page<O> findRecordsByCriteria(I searchObject, Pageable pageable) {
        log.info("findRecordsByCriteria, searchObject - {}, pageable - {}", searchObject, pageable);
        var specification = getSpecification(searchObject);
        log.debug("findRecordsByCriteria. specification - {}", specification);
        return specification.map(vehicleEntitySpecification -> repository.findAll(where(vehicleEntitySpecification), pageable)).orElse(null);
    }

    @Override
    public long countRecordsByCriteria(I searchObject) {
        log.info("countRecordsByCriteria, searchObject - {}", searchObject);
        var specification = getSpecification(searchObject);
        log.debug("countRecordsByCriteria. specification - {}", specification);
        return specification.map(vehicleEntitySpecification -> repository.count(where(vehicleEntitySpecification))).orElse(0L);
    }

    @Override
    public long getNumberOfAllRecords() {
        log.info("getNumberOfAllRecords");
        return repository.count();
    }

    @Override
    public O findRecord(T id) {
        log.info("findRecord, id - {}", id);
        return repository.findById(id).orElseThrow(() -> new RecordIsNotFoundException(id));
    }
}
