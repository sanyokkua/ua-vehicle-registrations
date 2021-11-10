package ua.vehicle.registrations.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.vehicle.registrations.enums.CriteriaOperations;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class Field<T> {

    private T mainOrMinValue;
    private T secondaryOrMaxValue;
    private CriteriaOperations operation;
}
