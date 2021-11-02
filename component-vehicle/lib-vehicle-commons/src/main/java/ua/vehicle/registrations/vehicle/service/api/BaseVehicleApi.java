package ua.vehicle.registrations.vehicle.service.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BaseVehicleApi<I, O> {

    Page<O> findRecordsByCriteria(I searchObject, Pageable pageable);

    long countRecordsByCriteria(I searchObject);

    long getNumberOfAllRecords();
}
