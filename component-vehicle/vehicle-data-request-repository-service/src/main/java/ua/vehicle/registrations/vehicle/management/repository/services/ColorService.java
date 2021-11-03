package ua.vehicle.registrations.vehicle.management.repository.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ua.vehicle.registrations.vehicle.management.repository.db.repositories.ColorRepository;
import ua.vehicle.registrations.vehicle.management.repository.utils.SpecificationUtils;
import ua.vehicle.registrations.vehicle.management.repository.db.jpa.ColorEntity;
import ua.vehicle.registrations.dto.searchable.ColorSearchableDto;

import java.util.Optional;

@Slf4j
@Service
public class ColorService extends BaseService<ColorSearchableDto, ColorEntity, String> {

    @Autowired
    public ColorService(SpecificationUtils<ColorEntity> specificationUtils, ColorRepository repository) {
        super(specificationUtils, repository);
    }

    @Override
    public Optional<Specification<ColorEntity>> getSpecification(ColorSearchableDto searchObject) {
        var colorName = searchObject.getColorName();
        return buildSpecification(createBaseSpecsForString(colorName, "colorName"));
    }
}
