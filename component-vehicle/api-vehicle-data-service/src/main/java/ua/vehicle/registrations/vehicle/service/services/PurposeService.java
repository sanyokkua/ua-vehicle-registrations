package ua.vehicle.registrations.vehicle.service.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.vehicle.registrations.vehicle.service.api.BaseVehicleApiWithId;
import ua.vehicle.registrations.vehicle.service.dto.flat.PurposeFlatDto;
import ua.vehicle.registrations.vehicle.service.dto.searchable.PurposeSearchableDto;

@Slf4j
@Service
public class PurposeService implements BaseVehicleApiWithId<PurposeSearchableDto, PurposeFlatDto, String> {

    @Override
    public Page<PurposeFlatDto> findRecordsByCriteria(PurposeSearchableDto searchObject, Pageable pageable) {
        return null;
    }

    @Override
    public long countRecordsByCriteria(PurposeSearchableDto searchObject) {
        return 0;
    }

    @Override
    public long getNumberOfAllRecords() {
        return 0;
    }

    @Override
    public PurposeFlatDto findRecord(String id) {
        return null;
    }
}
