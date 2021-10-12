package ua.vehicle.registrations.vehicle.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ua.vehicle.registrations.vehicle.service.api.CriteriaOperations;

import java.util.HashMap;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Body extends BaseDto {

    private String bodyType;

    @Override
    public void initPossibleOperations() {
        this.possibleOperations = new HashMap<>();
        this.possibleOperations.put("bodyType", List.of(CriteriaOperations.LIKE));
    }
}
