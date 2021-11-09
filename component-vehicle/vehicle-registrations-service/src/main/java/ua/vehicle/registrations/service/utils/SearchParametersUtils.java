package ua.vehicle.registrations.service.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ua.vehicle.registrations.annotations.FieldName;
import ua.vehicle.registrations.dto.flat.*;
import ua.vehicle.registrations.enums.RegistrationFields;
import ua.vehicle.registrations.service.dto.SearchEntityDto;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SearchParametersUtils {

    public static List<SearchEntityDto> getSearchParameters() {
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
                VehicleFlatDto.class
        ).map(dto -> {
            List<RegistrationFields> registrationFields;
            registrationFields = Arrays.stream(dto.getDeclaredFields())
                    .filter(Objects::nonNull)
                    .map(f -> f.getAnnotation(FieldName.class))
                    .filter(Objects::nonNull)
                    .map(FieldName::value)
                    .collect(Collectors.toList());
            return SearchEntityDto.builder().entityName(dto.getSimpleName()).entityFields(registrationFields).build();
        }).collect(Collectors.toList());
        log.info("Search params for each class is created: {}", entities);
        return entities;
    }
}
