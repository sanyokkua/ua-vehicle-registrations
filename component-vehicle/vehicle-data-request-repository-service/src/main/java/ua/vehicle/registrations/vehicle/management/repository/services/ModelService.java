package ua.vehicle.registrations.vehicle.management.repository.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ua.vehicle.registrations.vehicle.management.repository.repositories.ModelRepository;
import ua.vehicle.registrations.vehicle.management.repository.utils.SpecificationUtils;
import ua.vehicle.registrations.vehicle.service.dto.jpa.ModelEntity;
import ua.vehicle.registrations.vehicle.service.dto.searchable.ModelSearchableDto;

import java.util.Optional;

@Slf4j
@Service
public class ModelService extends BaseService<ModelSearchableDto, ModelEntity, String> {

    @Autowired
    public ModelService(SpecificationUtils<ModelEntity> specificationUtils, ModelRepository repository) {
        super(specificationUtils, repository);
    }

    @Override
    public Optional<Specification<ModelEntity>> getSpecification(ModelSearchableDto searchObject) {
        var modelName = searchObject.getModelName();
        return buildSpecification(createBaseSpecsForString(modelName, "modelName"));
    }
}
