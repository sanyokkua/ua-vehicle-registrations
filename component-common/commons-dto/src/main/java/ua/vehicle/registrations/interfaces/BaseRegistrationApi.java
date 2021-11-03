package ua.vehicle.registrations.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BaseRegistrationApi<I, O, T> {

    Page<O> findRecordsByCriteria(I searchObject, Pageable pageable);

    long countRecordsByCriteria(I searchObject);

    long getNumberOfAllRecords();

    O findRecord(T id);
}
