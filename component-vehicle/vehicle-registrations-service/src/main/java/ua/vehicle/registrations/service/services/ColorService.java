package ua.vehicle.registrations.service.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ua.vehicle.registrations.dto.flat.ColorFlatDto;
import ua.vehicle.registrations.dto.searchable.ColorSearchableDto;
import ua.vehicle.registrations.mappers.InputMapper;
import ua.vehicle.registrations.service.api.BaseRepository;
import ua.vehicle.registrations.service.db.entities.ColorEntity;
import ua.vehicle.registrations.service.utils.SpecificationUtils;

import java.util.Optional;

@Slf4j
@Service
public class ColorService extends BaseService<ColorSearchableDto, ColorFlatDto, ColorEntity, String> {

    @Autowired
    public ColorService(SpecificationUtils<ColorEntity> specificationUtils,
            BaseRepository<ColorEntity, String> repository,
            InputMapper<ColorEntity, ColorFlatDto> mapper
    ) {
        super(specificationUtils, repository, mapper);
    }

    @Override
    public Optional<Specification<ColorEntity>> getSpecification(ColorSearchableDto searchObject) {
        var colorName = searchObject.getColorName();
        return buildSpecification(createBaseSpecsForString(colorName, "colorName"));
    }
}
