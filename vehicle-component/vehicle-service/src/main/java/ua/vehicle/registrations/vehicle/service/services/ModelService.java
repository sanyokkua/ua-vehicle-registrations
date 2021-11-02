package ua.vehicle.registrations.vehicle.service.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.vehicle.registrations.vehicle.service.api.BaseVehicleApiWithId;
import ua.vehicle.registrations.vehicle.service.dto.flat.ModelFlatDto;
import ua.vehicle.registrations.vehicle.service.dto.searchable.ModelSearchableDto;

@Slf4j
@Service
public class ModelService implements BaseVehicleApiWithId<ModelSearchableDto, ModelFlatDto, String> {

    @Override
    public Page<ModelFlatDto> findRecordsByCriteria(ModelSearchableDto searchObject, Pageable pageable) {
        return null;
    }

    @Override
    public long countRecordsByCriteria(ModelSearchableDto searchObject) {
        return 0;
    }

    @Override
    public long getNumberOfAllRecords() {
        return 0;
    }

    @Override
    public ModelFlatDto findRecord(String id) {
        return null;
    }
}
