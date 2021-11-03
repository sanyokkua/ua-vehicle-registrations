package ua.vehicle.registrations.vehicle.service.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.vehicle.registrations.dto.flat.KindFlatDto;
import ua.vehicle.registrations.dto.searchable.KindSearchableDto;
import ua.vehicle.registrations.interfaces.BaseRegistrationApi;

@Slf4j
@Service
public class KindService implements BaseRegistrationApi<KindSearchableDto, KindFlatDto, String> {

    @Override
    public Page<KindFlatDto> findRecordsByCriteria(KindSearchableDto searchObject, Pageable pageable) {
        return null;
    }

    @Override
    public long countRecordsByCriteria(KindSearchableDto searchObject) {
        return 0;
    }

    @Override
    public long getNumberOfAllRecords() {
        return 0;
    }

    @Override
    public KindFlatDto findRecord(String id) {
        return null;
    }
}
