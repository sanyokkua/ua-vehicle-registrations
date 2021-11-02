package ua.vehicle.registrations.vehicle.service.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.vehicle.registrations.vehicle.service.api.BaseVehicleApiWithId;
import ua.vehicle.registrations.vehicle.service.dto.flat.BodyFlatDto;
import ua.vehicle.registrations.vehicle.service.dto.searchable.BodySearchableDto;

@Slf4j
@Service
public class BodyService implements BaseVehicleApiWithId<BodySearchableDto, BodyFlatDto, String> {

    @Override
    public Page<BodyFlatDto> findRecordsByCriteria(BodySearchableDto bodySearchableDto, Pageable pageable) {
        return null;
    }

    @Override
    public long countRecordsByCriteria(BodySearchableDto searchObject) {
        return 0;
    }

    @Override
    public long getNumberOfAllRecords() {
        return 0;
    }

    @Override
    public BodyFlatDto findRecord(String id) {
        return null;
    }
}
