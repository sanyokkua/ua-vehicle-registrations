package ua.vehicle.registrations.vehicle.service.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BaseEntityControllerApi<T, I> {

    Page<T> findRecordsByCriteria(SearchQuery searchQuery, Pageable pageable);

    int countRecordsByCriteria(SearchQuery searchQuery);

    int getNumberOfAllRecords();

    T findRecord(I id);
}
