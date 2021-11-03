package ua.vehicle.registrations.vehicle.service.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.vehicle.registrations.dto.flat.FuelFlatDto;
import ua.vehicle.registrations.dto.searchable.FuelSearchableDto;
import ua.vehicle.registrations.interfaces.BaseRegistrationApi;

@Slf4j
@Service
public class FuelService implements BaseRegistrationApi<FuelSearchableDto, FuelFlatDto, String> {

    @Override
    public Page<FuelFlatDto> findRecordsByCriteria(FuelSearchableDto searchObject, Pageable pageable) {
        return null;
    }

    @Override
    public long countRecordsByCriteria(FuelSearchableDto searchObject) {
        return 0;
    }

    @Override
    public long getNumberOfAllRecords() {
        return 0;
    }

    @Override
    public FuelFlatDto findRecord(String id) {
        return null;
    }
}
