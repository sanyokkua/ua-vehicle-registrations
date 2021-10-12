package ua.vehicle.registrations.vehicle.service.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.vehicle.registrations.vehicle.service.api.CriteriaOperations;
import ua.vehicle.registrations.vehicle.service.dto.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class UtilsService {

    public SearchParametersDto getSearchParameters() {
        var baseDtos = List.of(
                Body.builder().build(),
                Brand.builder().build(),
                Color.builder().build(),
                Department.builder().build(),
                Fuel.builder().build(),
                Kind.builder().build(),
                Model.builder().build(),
                Operation.builder().build(),
                Purpose.builder().build(),
                Registration.builder().build(),
                Vehicle.builder().build()
        );
        log.info("Created list with base dto: {}", baseDtos);
        baseDtos.forEach(BaseDto::initPossibleOperations);
        log.info("List with base dto is initialized with search params");
        Map<String, Map<String, List<CriteriaOperations>>> params = new HashMap<>();
        baseDtos.forEach(dto -> params.put(dto.getClass().getSimpleName(), dto.getPossibleOperations()));
        log.info("Search params for each class is created: {}", params);
        return SearchParametersDto.builder().searchOperationsByTypes(params).build();
    }
}
