package ua.vehicle.registrations.vehicle.service.dto;

import lombok.*;
import ua.vehicle.registrations.vehicle.service.api.CriteriaOperations;

import java.util.HashMap;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Model extends BaseDto {

    private String modelName;

    @Override
    public void initPossibleOperations() {
        this.possibleOperations = new HashMap<>();
        this.possibleOperations.put("modelName", List.of(CriteriaOperations.LIKE));
    }
}
