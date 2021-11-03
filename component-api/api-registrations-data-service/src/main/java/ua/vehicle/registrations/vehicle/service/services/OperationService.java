package ua.vehicle.registrations.vehicle.service.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.vehicle.registrations.dto.flat.OperationFlatDto;
import ua.vehicle.registrations.dto.searchable.OperationSearchableDto;
import ua.vehicle.registrations.interfaces.BaseRegistrationApi;

@Slf4j
@Service
public class OperationService implements BaseRegistrationApi<OperationSearchableDto, OperationFlatDto, Long> {

    @Override
    public Page<OperationFlatDto> findRecordsByCriteria(OperationSearchableDto searchObject, Pageable pageable) {
        return null;
    }

    @Override
    public long countRecordsByCriteria(OperationSearchableDto searchObject) {
        return 0;
    }

    @Override
    public long getNumberOfAllRecords() {
        return 0;
    }

    @Override
    public OperationFlatDto findRecord(Long id) {
        return null;
    }
}
