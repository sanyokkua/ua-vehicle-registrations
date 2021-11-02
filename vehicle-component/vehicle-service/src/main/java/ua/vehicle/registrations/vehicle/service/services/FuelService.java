package ua.vehicle.registrations.vehicle.service.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.vehicle.registrations.vehicle.service.api.BaseVehicleApiWithId;
import ua.vehicle.registrations.vehicle.service.dto.flat.FuelFlatDto;
import ua.vehicle.registrations.vehicle.service.dto.searchable.FuelSearchableDto;

@Slf4j
@Service
public class FuelService implements BaseVehicleApiWithId<FuelSearchableDto, FuelFlatDto, String> {

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
