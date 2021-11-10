package ua.vehicle.registrations.service.api;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BaseRepository<T, D> extends PagingAndSortingRepository<T, D>, JpaSpecificationExecutor<T> {}
