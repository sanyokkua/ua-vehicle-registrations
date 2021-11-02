package ua.vehicle.registrations.vehicle.service.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.vehicle.registrations.vehicle.service.api.BaseVehicleApiWithId;
import ua.vehicle.registrations.vehicle.service.dto.flat.ColorFlatDto;
import ua.vehicle.registrations.vehicle.service.dto.searchable.ColorSearchableDto;

@Slf4j
@Service
public class ColorService implements BaseVehicleApiWithId<ColorSearchableDto, ColorFlatDto, String> {

    @Override
    public Page<ColorFlatDto> findRecordsByCriteria(ColorSearchableDto searchObject, Pageable pageable) {
        return null;
    }

    @Override
    public long countRecordsByCriteria(ColorSearchableDto searchObject) {
        return 0;
    }

    @Override
    public long getNumberOfAllRecords() {
        return 0;
    }

    @Override
    public ColorFlatDto findRecord(String id) {
        return null;
    }
}
