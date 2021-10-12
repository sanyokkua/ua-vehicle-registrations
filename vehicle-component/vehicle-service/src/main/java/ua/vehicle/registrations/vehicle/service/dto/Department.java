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
public class Department extends BaseDto {

    private Long depCode;
    private String depName;

    @Override
    public void initPossibleOperations() {
        this.possibleOperations = new HashMap<>();
        this.possibleOperations.put("depCode", List.of(CriteriaOperations.IS));
        this.possibleOperations.put("depName", List.of(CriteriaOperations.LIKE));
    }
}
