package ua.vehicle.registrations.service.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ua.vehicle.registrations.dto.flat.RegistrationFlatDto;
import ua.vehicle.registrations.dto.searchable.RegistrationSearchableDto;
import ua.vehicle.registrations.mappers.InputMapper;
import ua.vehicle.registrations.service.api.BaseRepository;
import ua.vehicle.registrations.service.db.entities.RegistrationEntity;
import ua.vehicle.registrations.service.utils.SpecificationUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
public class RegistrationService extends BaseService<RegistrationSearchableDto, RegistrationFlatDto,
        RegistrationEntity, Long> {

    @Autowired
    public RegistrationService(SpecificationUtils<RegistrationEntity> specificationUtils,
            BaseRepository<RegistrationEntity, Long> repository,
            InputMapper<RegistrationEntity, RegistrationFlatDto> mapper
    ) {
        super(specificationUtils, repository, mapper);
    }

    @Override
    public Optional<Specification<RegistrationEntity>> getSpecification(RegistrationSearchableDto searchObject) {
        var personType = searchObject.getPersonType();
        var personRegAddress = searchObject.getPersonRegAddress();
        var regNumber = searchObject.getRegNumber();
        var vinNumber = searchObject.getVinNumber();
        var colorName = searchObject.getColorName();
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
        var opCode = searchObject.getOpCode();
        var opName = searchObject.getOpName();
        var depCode = searchObject.getDepCode();
        var depName = searchObject.getDepName();
        return buildSpecification(Stream.of(
                createBaseSpecsForString(personType, "personType"),
                createBaseSpecsForString(personRegAddress, "personRegAddress"),
                createBaseSpecsForString(regNumber, "regNumber"),
                createBaseSpecsForString(vinNumber, "vinNumber"),
                createBaseSpecsForString(colorName, "color", "colorName"),
                createBaseSpecsForString(brandName, "vehicle", "brand", "brandName"),
                createBaseSpecsForString(modelName, "vehicle", "model", "modelName"),
                createBaseSpecsForString(bodyType, "vehicle", "body", "bodyType"),
                createBaseSpecsForString(kindName, "vehicle", "kind", "kindName"),
                createBaseSpecsForString(fuelType, "vehicle", "fuel", "fuelType"),
                createBaseSpecsForString(purposeName, "vehicle", "purpose", "purposeName"),
                createBaseSpecsForLong(engineCapacity, "vehicle", "engineCapacity"),
                createBaseSpecsForLong(makeYear, "vehicle", "makeYear"),
                createBaseSpecsForLong(ownWeight, "vehicle", "ownWeight"),
                createBaseSpecsForLong(totalWeight, "vehicle", "totalWeight"),
                createBaseSpecsForLong(opCode, "operation", "opCode"),
                createBaseSpecsForString(opName, "operation", "opName"),
                createBaseSpecsForLong(depCode, "department", "depCode"),
                createBaseSpecsForString(depName, "department", "depName")
        ).flatMap(List::stream).collect(Collectors.toList()));
    }
}
