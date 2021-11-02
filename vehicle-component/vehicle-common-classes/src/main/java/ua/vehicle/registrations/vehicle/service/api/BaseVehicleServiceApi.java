package ua.vehicle.registrations.vehicle.service.api;

import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;

public interface BaseVehicleServiceApi<I, O, T> extends BaseVehicleApiWithId<I, O, T> {

    Optional<Specification<O>> getSpecification(I searchObject);
}