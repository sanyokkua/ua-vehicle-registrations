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
public class Purpose extends BaseDto {

    private String purposeName;

    @Override
    public void initPossibleOperations() {
        this.possibleOperations = new HashMap<>();
        this.possibleOperations.put("purposeName", List.of(CriteriaOperations.LIKE));
    }
}
