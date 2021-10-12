package ua.vehicle.registrations.vehicle.service.dto;

import lombok.*;
import ua.vehicle.registrations.vehicle.service.api.CriteriaOperations;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Registration extends BaseDto {

    private Long regId;
    private String personType;
    private String personRegAddress;
    private LocalDate regDate;
    private String regNumber;
    private String vinNumber;
    private String colorName;
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
    private Long opCode;
    private String opName;
    private Long depCode;
    private String depName;

    @Override
    public void initPossibleOperations() {
        this.possibleOperations = new HashMap<>();
        this.possibleOperations.put("bodyType", List.of(CriteriaOperations.LIKE));
        this.possibleOperations.put("personType", List.of(CriteriaOperations.LIKE));
        this.possibleOperations.put("personRegAddress", List.of(CriteriaOperations.IS));
        this.possibleOperations.put("regDate", List.of(CriteriaOperations.IS, CriteriaOperations.RANGE));
        this.possibleOperations.put("regNumber", List.of(CriteriaOperations.LIKE));
        this.possibleOperations.put("vinNumber", List.of(CriteriaOperations.IS));
        this.possibleOperations.put("colorName", List.of(CriteriaOperations.LIKE));
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
        this.possibleOperations.put("opCode", List.of(CriteriaOperations.IS));
        this.possibleOperations.put("opName", List.of(CriteriaOperations.LIKE));
        this.possibleOperations.put("depCode", List.of(CriteriaOperations.IS));
        this.possibleOperations.put("depName", List.of(CriteriaOperations.LIKE));
    }
}
