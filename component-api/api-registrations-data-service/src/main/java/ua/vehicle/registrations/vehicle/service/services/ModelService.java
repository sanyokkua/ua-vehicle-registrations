package ua.vehicle.registrations.vehicle.service.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.vehicle.registrations.dto.flat.ModelFlatDto;
import ua.vehicle.registrations.dto.searchable.ModelSearchableDto;
import ua.vehicle.registrations.interfaces.BaseRegistrationApi;

@Slf4j
@Service
public class ModelService implements BaseRegistrationApi<ModelSearchableDto, ModelFlatDto, String> {

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
