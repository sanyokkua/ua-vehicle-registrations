package ua.vehicle.registrations.vehicle.service.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.vehicle.registrations.dto.flat.BrandFlatDto;
import ua.vehicle.registrations.dto.searchable.BrandSearchableDto;
import ua.vehicle.registrations.interfaces.BaseRegistrationApi;

@Slf4j
@Service
public class BrandService implements BaseRegistrationApi<BrandSearchableDto, BrandFlatDto, String> {

    @Override
    public Page<BrandFlatDto> findRecordsByCriteria(BrandSearchableDto bodySearchableDto, Pageable pageable) {
        return null;
    }

    @Override
    public long countRecordsByCriteria(BrandSearchableDto searchObject) {
        return 0;
    }

    @Override
    public long getNumberOfAllRecords() {
        return 0;
    }

    @Override
    public BrandFlatDto findRecord(String id) {
        return null;
    }
}
