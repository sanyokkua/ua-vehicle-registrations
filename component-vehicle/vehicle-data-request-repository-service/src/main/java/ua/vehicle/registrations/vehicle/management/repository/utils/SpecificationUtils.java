package ua.vehicle.registrations.vehicle.management.repository.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ua.vehicle.registrations.enums.CriteriaOperations;
import ua.vehicle.registrations.dto.Field;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Component
public class SpecificationUtils<I> {

    private <T> boolean isValidParams(Field<T> value, String... path) {
        log.debug("isValidParams, value - {}, path - {}", value, path);
        return Arrays.stream(path).noneMatch(StringUtils::isBlank) && Objects.nonNull(value);
    }

    private <T> boolean isValidIs(Field<T> value) {
        log.debug("isValidIs, value - {}", value);
        return CriteriaOperations.IS.equals(value.getOperation()) && Objects.nonNull(value.getMainOrMinValue());
    }

    private <T> boolean isValidGreaterThanOrEqualTo(Field<T> value) {
        log.debug("isValidGreaterThanOrEqualTo, value - {}", value);
        return CriteriaOperations.IS.equals(value.getOperation()) && Objects.nonNull(value.getMainOrMinValue());
    }

    private boolean isValidLessThanOrEqualTo(Field<Long> value) {
        log.debug("isValidLessThanOrEqualTo, value - {}", value);
        return CriteriaOperations.GREATER_THAN.equals(value.getOperation()) && Objects.nonNull(value.getMainOrMinValue());
    }

    private boolean isValidLike(Field<String> value) {
        log.debug("isValidLike, value - {}", value);
        return CriteriaOperations.LIKE.equals(value.getOperation()) && Objects.nonNull(value.getMainOrMinValue());
    }

    private <T> Path<T> buildPath(Root<I> objRoot, String[] path) {
        log.debug("buildPath, root - {}, path - {}", objRoot, path);
        Path<T> root = objRoot.get(path[0]);
        for (int i = 1; i < path.length; i++) {
            root = root.get(path[i]);
        }
        log.debug("buildPath, finalPath - {}", root);
        return root;
    }

    public <T> Optional<Specification<I>> equalTo(Field<T> value, String... path) {
        if (isValidParams(value, path) && isValidIs(value)) {
            return Optional.of((objRoot, cq, cb) -> cb.equal(buildPath(objRoot, path), value.getMainOrMinValue()));
        }
        log.info("equalTo, Optional.empty() will be returned");
        return Optional.empty();
    }

    public Optional<Specification<I>> greaterThanOrEqualTo(Field<Long> value, String... path) {
        if (isValidParams(value, path) && isValidGreaterThanOrEqualTo(value)) {
            return Optional.of((objRoot, cq, cb) -> cb.greaterThanOrEqualTo(buildPath(objRoot, path), value.getMainOrMinValue()));
        }
        log.info("greaterThanOrEqualTo, Optional.empty() will be returned");
        return Optional.empty();
    }

    public Optional<Specification<I>> lessThanOrEqualTo(Field<Long> value, String... path) {
        if (isValidParams(value, path) && isValidLessThanOrEqualTo(value)) {
            return Optional.of((objRoot, cq, cb) -> cb.lessThanOrEqualTo(buildPath(objRoot, path), value.getSecondaryOrMaxValue()));
        }
        log.info("lessThanOrEqualTo, Optional.empty() will be returned");
        return Optional.empty();
    }

    public Optional<Specification<I>> likeTo(Field<String> value, String... path) {
        if (isValidParams(value, path) && isValidLike(value)) {
            return Optional.of((objRoot, cq, cb) -> cb.like(buildPath(objRoot, path), "%" + value.getMainOrMinValue() + "%"));
        }
        log.info("likeTo, Optional.empty() will be returned");
        return Optional.empty();
    }
}