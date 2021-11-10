package ua.vehicle.registrations.service.api;

import org.springframework.data.jpa.domain.Specification;
import ua.vehicle.registrations.interfaces.BaseRegistrationApi;

import java.util.Optional;

public interface BaseVehicleServiceApi<IN, OUT, JPA, ID> extends BaseRegistrationApi<IN, OUT, ID> {

    Optional<Specification<JPA>> getSpecification(IN searchObject);
}
