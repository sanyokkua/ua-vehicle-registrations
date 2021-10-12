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
public class Operation extends BaseDto {

    private Long opCode;
    private String opName;

    @Override
    public void initPossibleOperations() {
        this.possibleOperations = new HashMap<>();
        this.possibleOperations.put("opCode", List.of(CriteriaOperations.IS));
        this.possibleOperations.put("opName", List.of(CriteriaOperations.LIKE));
    }
}
