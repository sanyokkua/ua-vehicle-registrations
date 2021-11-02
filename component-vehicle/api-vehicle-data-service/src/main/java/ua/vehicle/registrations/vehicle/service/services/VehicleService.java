package ua.vehicle.registrations.vehicle.service.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.vehicle.registrations.vehicle.service.api.BaseVehicleApiWithId;
import ua.vehicle.registrations.vehicle.service.dto.flat.VehicleFlatDto;
import ua.vehicle.registrations.vehicle.service.dto.searchable.VehicleSearchableDto;

@Slf4j
@Service
public class VehicleService implements BaseVehicleApiWithId<VehicleSearchableDto, VehicleFlatDto, Long> {

    @Override
    public Page<VehicleFlatDto> findRecordsByCriteria(VehicleSearchableDto searchObject, Pageable pageable) {
        return null;
    }

    @Override
    public long countRecordsByCriteria(VehicleSearchableDto searchObject) {
        return 0;
    }

    @Override
    public long getNumberOfAllRecords() {
        return 0;
    }

    @Override
    public VehicleFlatDto findRecord(Long id) {
        return null;
    }
}
