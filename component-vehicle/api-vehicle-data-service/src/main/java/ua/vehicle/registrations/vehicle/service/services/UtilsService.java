package ua.vehicle.registrations.vehicle.service.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.vehicle.registrations.vehicle.service.api.FieldName;
import ua.vehicle.registrations.vehicle.service.api.RegistrationFields;
import ua.vehicle.registrations.vehicle.service.dto.SearchEntityDto;
import ua.vehicle.registrations.vehicle.service.dto.flat.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
public class UtilsService {

    public List<SearchEntityDto> getSearchParameters() {
        var entities = Stream.of(
                        BodyFlatDto.class,
                        BrandFlatDto.class,
                        ColorFlatDto.class,
                        DepartmentFlatDto.class,
                        FuelFlatDto.class,
                        KindFlatDto.class,
                        ModelFlatDto.class,
                        OperationFlatDto.class,
                        PurposeFlatDto.class,
                        RegistrationFlatDto.class,
                        VehicleFlatDto.class)
                .map(dto -> {
                    List<RegistrationFields> registrationFields;
                    registrationFields = Arrays.stream(dto.getDeclaredFields())
                            .filter(Objects::nonNull)
                            .map(f -> f.getAnnotation(FieldName.class))
                            .filter(Objects::nonNull)
                            .map(FieldName::value)
                            .collect(Collectors.toList());
                    return SearchEntityDto.builder()
                            .entityName(dto.getSimpleName())
                            .entityFields(registrationFields)
                            .build();
                })
                .collect(Collectors.toList());
        log.info("Search params for each class is created: {}", entities);
        return entities;
    }
}
