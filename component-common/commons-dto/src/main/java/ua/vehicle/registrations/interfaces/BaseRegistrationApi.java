package ua.vehicle.registrations.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BaseRegistrationApi<IN, OUT, ID> {

    Page<OUT> findRecordsByCriteria(IN searchObject, Pageable pageable);
    long countRecordsByCriteria(IN searchObject);
    long getNumberOfAllRecords();
    OUT findRecord(ID id);
}
