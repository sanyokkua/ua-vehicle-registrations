package ua.vehicle.registrations.service.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ua.vehicle.registrations.dto.flat.VehicleFlatDto;
import ua.vehicle.registrations.dto.searchable.VehicleSearchableDto;
import ua.vehicle.registrations.mappers.InputMapper;
import ua.vehicle.registrations.service.api.BaseRepository;
import ua.vehicle.registrations.service.db.entities.VehicleEntity;
import ua.vehicle.registrations.service.utils.SpecificationUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
public class VehicleService extends BaseService<VehicleSearchableDto, VehicleFlatDto, VehicleEntity, Long> {

    @Autowired
    public VehicleService(SpecificationUtils<VehicleEntity> specificationUtils,
            BaseRepository<VehicleEntity, Long> repository,
            InputMapper<VehicleEntity, VehicleFlatDto> mapper
    ) {
        super(specificationUtils, repository, mapper);
    }

    @Override
    public Optional<Specification<VehicleEntity>> getSpecification(VehicleSearchableDto searchObject) {
        var engineCapacity = searchObject.getEngineCapacity();
        var makeYear = searchObject.getMakeYear();
        var ownWeight = searchObject.getOwnWeight();
        var totalWeight = searchObject.getTotalWeight();
        var brandName = searchObject.getBrandName();
        var modelName = searchObject.getModelName();
        var bodyType = searchObject.getBodyType();
        var kindName = searchObject.getKindName();
        var fuelType = searchObject.getFuelType();
        var purposeName = searchObject.getPurposeName();
        return buildSpecification(Stream.of(
                createBaseSpecsForLong(engineCapacity, "engineCapacity"),
                createBaseSpecsForLong(makeYear, "makeYear"),
                createBaseSpecsForLong(ownWeight, "ownWeight"),
                createBaseSpecsForLong(totalWeight, "totalWeight"),
                createBaseSpecsForString(brandName, "brand", "brandName"),
                createBaseSpecsForString(modelName, "model", "modelName"),
                createBaseSpecsForString(bodyType, "body", "bodyType"),
                createBaseSpecsForString(kindName, "kind", "kindName"),
                createBaseSpecsForString(fuelType, "fuel", "fuelType"),
                createBaseSpecsForString(purposeName, "purpose", "purposeName")
        ).flatMap(List::stream).collect(Collectors.toList()));
    }
}
