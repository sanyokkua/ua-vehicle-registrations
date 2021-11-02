package ua.vehicle.registrations.vehicle.service.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class Field<T> {

    private T mainOrMinValue;
    private T secondaryOrMaxValue;
    private CriteriaOperations operation;
}
