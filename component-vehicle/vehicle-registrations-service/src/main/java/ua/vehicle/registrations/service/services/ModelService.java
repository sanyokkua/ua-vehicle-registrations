package ua.vehicle.registrations.service.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ua.vehicle.registrations.dto.flat.ModelFlatDto;
import ua.vehicle.registrations.dto.searchable.ModelSearchableDto;
import ua.vehicle.registrations.mappers.InputMapper;
import ua.vehicle.registrations.service.api.BaseRepository;
import ua.vehicle.registrations.service.db.entities.ModelEntity;
import ua.vehicle.registrations.service.utils.SpecificationUtils;

import java.util.Optional;

@Slf4j
@Service
public class ModelService extends BaseService<ModelSearchableDto, ModelFlatDto, ModelEntity, String> {

    @Autowired
    public ModelService(SpecificationUtils<ModelEntity> specificationUtils,
            BaseRepository<ModelEntity, String> repository,
            InputMapper<ModelEntity, ModelFlatDto> mapper
    ) {
        super(specificationUtils, repository, mapper);
    }

    @Override
    public Optional<Specification<ModelEntity>> getSpecification(ModelSearchableDto searchObject) {
        var modelName = searchObject.getModelName();
        return buildSpecification(createBaseSpecsForString(modelName, "modelName"));
    }
}
