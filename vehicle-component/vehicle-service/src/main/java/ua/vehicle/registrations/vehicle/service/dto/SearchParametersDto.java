package ua.vehicle.registrations.vehicle.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.vehicle.registrations.vehicle.service.api.CriteriaOperations;

import java.util.List;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SearchParametersDto {

    private Map<String, Map<String, List<CriteriaOperations>>> searchOperationsByTypes;
}
