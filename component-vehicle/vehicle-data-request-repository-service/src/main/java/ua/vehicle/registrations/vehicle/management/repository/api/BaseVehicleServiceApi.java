package ua.vehicle.registrations.vehicle.management.repository.api;

import org.springframework.data.jpa.domain.Specification;
import ua.vehicle.registrations.interfaces.BaseRegistrationApi;

import java.util.Optional;

public interface BaseVehicleServiceApi<I, O, T> extends BaseRegistrationApi<I, O, T> {

    Optional<Specification<O>> getSpecification(I searchObject);
}
