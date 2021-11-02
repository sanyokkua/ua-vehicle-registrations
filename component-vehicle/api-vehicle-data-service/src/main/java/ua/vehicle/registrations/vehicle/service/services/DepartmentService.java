package ua.vehicle.registrations.vehicle.service.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.vehicle.registrations.vehicle.service.api.BaseVehicleApiWithId;
import ua.vehicle.registrations.vehicle.service.dto.flat.DepartmentFlatDto;
import ua.vehicle.registrations.vehicle.service.dto.searchable.DepartmentSearchableDto;

@Slf4j
@Service
public class DepartmentService implements BaseVehicleApiWithId<DepartmentSearchableDto, DepartmentFlatDto, Long> {

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
