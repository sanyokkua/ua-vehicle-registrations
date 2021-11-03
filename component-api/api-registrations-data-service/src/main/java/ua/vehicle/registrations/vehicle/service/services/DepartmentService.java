package ua.vehicle.registrations.vehicle.service.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.vehicle.registrations.dto.flat.DepartmentFlatDto;
import ua.vehicle.registrations.dto.searchable.DepartmentSearchableDto;
import ua.vehicle.registrations.interfaces.BaseRegistrationApi;

@Slf4j
@Service
public class DepartmentService implements BaseRegistrationApi<DepartmentSearchableDto, DepartmentFlatDto, Long> {

    @Override
    public Page<DepartmentFlatDto> findRecordsByCriteria(DepartmentSearchableDto searchObject, Pageable pageable) {
        return null;
    }

    @Override
    public long countRecordsByCriteria(DepartmentSearchableDto searchObject) {
        return 0;
    }

    @Override
    public long getNumberOfAllRecords() {
        return 0;
    }

    @Override
    public DepartmentFlatDto findRecord(Long id) {
        return null;
    }
}
