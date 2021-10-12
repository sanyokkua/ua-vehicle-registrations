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
public class Vehicle extends BaseDto {

    private Long vehicleId;
    private String brandName;
    private String modelName;
    private String bodyType;
    private String kindName;
    private String fuelType;
    private String purposeName;
    private int engineCapacity;
    private int makeYear;
    private int ownWeight;
    private int totalWeight;

    @Override
    public void initPossibleOperations() {
        this.possibleOperations = new HashMap<>();
        this.possibleOperations.put("brandName", List.of(CriteriaOperations.LIKE));
        this.possibleOperations.put("modelName", List.of(CriteriaOperations.LIKE));
        this.possibleOperations.put("bodyType", List.of(CriteriaOperations.LIKE));
        this.possibleOperations.put("kindName", List.of(CriteriaOperations.LIKE));
        this.possibleOperations.put("fuelType", List.of(CriteriaOperations.LIKE));
        this.possibleOperations.put("purposeName", List.of(CriteriaOperations.LIKE));
        this.possibleOperations.put("engineCapacity", List.of(CriteriaOperations.IS, CriteriaOperations.RANGE));
        this.possibleOperations.put("makeYear", List.of(CriteriaOperations.IS, CriteriaOperations.RANGE));
        this.possibleOperations.put("ownWeight", List.of(CriteriaOperations.IS, CriteriaOperations.RANGE));
        this.possibleOperations.put("totalWeight", List.of(CriteriaOperations.IS, CriteriaOperations.RANGE));
    }
}
