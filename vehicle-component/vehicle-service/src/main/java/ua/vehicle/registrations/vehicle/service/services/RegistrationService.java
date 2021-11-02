package ua.vehicle.registrations.vehicle.service.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.vehicle.registrations.vehicle.service.api.BaseVehicleApiWithId;
import ua.vehicle.registrations.vehicle.service.dto.flat.RegistrationFlatDto;
import ua.vehicle.registrations.vehicle.service.dto.searchable.RegistrationSearchableDto;

@Slf4j
@Service
public class RegistrationService implements BaseVehicleApiWithId<RegistrationSearchableDto, RegistrationFlatDto, Long> {

    @Override
    public Page<RegistrationFlatDto> findRecordsByCriteria(RegistrationSearchableDto searchObject, Pageable pageable) {
        return null;
    }

    @Override
    public long countRecordsByCriteria(RegistrationSearchableDto searchObject) {
        return 0;
    }

    @Override
    public long getNumberOfAllRecords() {
        return 0;
    }

    @Override
    public RegistrationFlatDto findRecord(Long id) {
        return null;
    }
}
